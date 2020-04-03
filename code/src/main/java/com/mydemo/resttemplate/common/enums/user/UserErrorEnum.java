package com.mydemo.resttemplate.common.enums.user;

import com.mydemo.resttemplate.common.base.IBaseEnum;
import org.springframework.core.annotation.Order;

@Order(10000)
public enum UserErrorEnum implements IBaseEnum {
    USER_EXIST("11001", "用户已经存在"),
    USER_NOT_EXIST("11002", "用户不存在或已被删除"),
    USER_NAME_NOT_EMPTY_OR_NULL("11003", "用户名称不能为空"),
    USER_ID_NOT_NULL("11004", "用户ID不能为空");

    private String code;
    private String errMsg;

    UserErrorEnum(String code, String errMsg) {
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
