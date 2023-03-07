package com.inzone.mall.util.entity;

import lombok.Data;

/**
 * @Description: TODO
 * @author: xulong
 * @date: 2023年03月02日10:48
 */
@Data
public class PropertyModelInfo {
    /**
     * 属性名
     */
    private String propertyName;
    /**
     * 属性值
     */
    private Object value;
    /**
     * 返回值类型
     */
    private Class<?> returnType;
}
