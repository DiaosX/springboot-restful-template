package com.mydemo.resttemplate.common.enums.blog;

import com.mydemo.resttemplate.common.base.IBaseEnum;
import org.springframework.core.annotation.Order;

@Order(20000)
public enum BlogErrorEnum implements IBaseEnum {
    BLOG_EXIST("21001", "博客已经存在"),
    BLOG_NOT_EXIST("21002", "博客不存在或已被删除"),
    BLOG_NAME_NOT_EMPTY("21003", "博客名称不能为空"),
    BLOG_TYPE_NOT_EMPTY("21004", "博客类型不能为空");

    BlogErrorEnum(String code, String errMsg) {
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
