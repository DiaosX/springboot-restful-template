package com.mydemo.resttemplate.common.enums;

import com.mydemo.resttemplate.common.base.BaseError;
import org.springframework.core.annotation.Order;

@Order(20000)
public enum ErrorCodeEnum_Blog implements BaseError {
    BLOG_EXIST("21001", "博客已经存在"),
    BLOG_NOT_EXIST("21002", "博客不存在或已被删除"),
    BLOG_NAME_NOT_EMPTY("21003", "博客名称不能为空"),
    BLOG_TYPE_NOT_EMPTY("21004", "博客类型不能为空");

    ErrorCodeEnum_Blog(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    private String code;
    private String errMsg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return errMsg;
    }
}
