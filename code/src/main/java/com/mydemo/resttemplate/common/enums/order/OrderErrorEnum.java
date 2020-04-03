package com.mydemo.resttemplate.common.enums.order;

import com.mydemo.resttemplate.common.base.IBaseEnum;
import org.springframework.core.annotation.Order;

@Order(30000)
public enum OrderErrorEnum implements IBaseEnum {
    Order_EXIST("31001", "订单已经存在"),
    Order_NOT_EXIST("31002", "订单不存在或已被删除"),
    Order_NAME_NOT_EMPTY("31003", "订单名称不能为空");

    private String code;
    private String errMsg;

    OrderErrorEnum(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return errMsg;
    }
}
