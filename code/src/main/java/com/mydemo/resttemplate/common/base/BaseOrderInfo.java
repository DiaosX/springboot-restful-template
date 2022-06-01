package com.mydemo.resttemplate.common.base;


/**
 * @Author yst
 * @Date 2021/10/28 10:23 上午
 * @Version 1.0
 * @Desc 基础排序信息
 */
public class BaseOrderInfo {
    /**
     * 排序字段名字
     */
    protected String orderFieldName;
    /**
     * 排序类型，ASC-升序，DESC-降
     */
    protected String orderType;

    public String getOrderFieldName() {
        return orderFieldName;
    }

    public void setOrderFieldName(String orderFieldName) {
        this.orderFieldName = orderFieldName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
