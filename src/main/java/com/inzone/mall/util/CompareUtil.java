package com.inzone.mall.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.inzone.mall.util.entity.ModifiedPropertyInfo;
import com.inzone.mall.util.entity.PropertyModelInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Description: TODO
 * @author: xulong
 * @date: 2023年03月02日10:42
 */
@Component
@Slf4j
public class CompareUtil {
    public static <T> List<JSONObject> getDifferentProperty(T oldObj, T newObj, String primaryKey, String... ignoreProperties){
        if(oldObj != null && newObj !=null){
            // 比较全部字段
            if(ignoreProperties == null || ignoreProperties.length == 0){
                if(oldObj.equals(newObj)){
                    return Collections.emptyList();
                }
            }
            List<PropertyModelInfo> oldObjectPropertyValue = getObjectPropertyValue(oldObj, ignoreProperties);
            if(CollectionUtils.isNotEmpty(oldObjectPropertyValue)){
                ArrayList<JSONObject> modifiedPropertyInfos = new ArrayList<>(oldObjectPropertyValue.size());
                List<PropertyModelInfo> newObjectPropertyInfos = getObjectPropertyValue(newObj, ignoreProperties);
                HashMap<Object, Object> objectHashMap = new HashMap<>(newObjectPropertyInfos.size());
                // 获取新对象的所有属性值
                for (PropertyModelInfo propertyModelInfo : newObjectPropertyInfos) {
                    String propertyName = propertyModelInfo.getPropertyName();
                    Object value = propertyModelInfo.getValue();
                    objectHashMap.put(propertyName,value);
                }
                for (PropertyModelInfo propertyModelInfo : oldObjectPropertyValue) {
                    String propertyName = propertyModelInfo.getPropertyName();
                    Object value = propertyModelInfo.getValue();
                    if(objectHashMap.containsKey(propertyName)){
                        Object newValue = objectHashMap.get(propertyName);
                        JSONObject modifiedPropertyInfo = new JSONObject();
                        boolean flag = false;
                        if(ObjectUtil.equal(value,newValue)){
                            flag = true;
                        }
                        if(!flag){
                            log.info("存在差异属性名:{},订单中心值:{},云逛街值：{}", propertyName, newValue, value);
                            modifiedPropertyInfo.put(primaryKey, objectHashMap.get(primaryKey));
                            modifiedPropertyInfo.put(propertyName, newValue);
                            modifiedPropertyInfos.add(modifiedPropertyInfo);
                        }
                    }
                }
                return modifiedPropertyInfos;
            }
        }
        return Collections.emptyList();
    }

    /**
     * 通过反射获取对象的属性名称，getter返回值类型，属性值等信息。
     * @param obj
     * @param ignoreProperties
     * @param <T>
     * @return
     */
    public static <T> List<PropertyModelInfo> getObjectPropertyValue(T obj, String... ignoreProperties){
        if(obj != null){
            Class<?> aClass = obj.getClass();
            PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(aClass);
            List<PropertyModelInfo> modelInfos = new ArrayList<>(propertyDescriptors.length);
            List<String> ignoreList = ignoreProperties != null ? Arrays.asList(ignoreProperties) : null ;
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                Method readMethod = propertyDescriptor.getReadMethod();
                String name = propertyDescriptor.getName();
                if(readMethod != null && (CollectionUtils.isEmpty(ignoreList) || !ignoreList.contains(name))){
                    Object invoke = null;
                    Class<?> returnType = readMethod.getReturnType();
                    try {
                        invoke = readMethod.invoke(obj);
                        PropertyModelInfo propertyModelInfo = new PropertyModelInfo();
                        propertyModelInfo.setPropertyName(name);
                        propertyModelInfo.setValue(invoke);
                        propertyModelInfo.setReturnType(returnType);
                        modelInfos.add(propertyModelInfo);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        log.error("反射获取类[" + aClass.getName() + "]方法异常", e);
                    }
                }
            }
            return modelInfos;
        }
        return Collections.emptyList();
    }


    public static <T,R> Boolean checkObj(T t, R r){
        return t.equals(r);
    }

}
