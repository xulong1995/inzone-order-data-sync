package com.inzone.mall.util.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: xulong
 * @date: 2023年03月02日10:46
 */
@Data
public class ModifiedPropertyInfo implements Serializable {
    /**
     * 对应的属性名
     */
    private String propertyName;

    /**
     * 未修改之前的值
     */
    private Object oldValue;

    /**
     * 修改后的值
     */
    private Object newValue;
}
