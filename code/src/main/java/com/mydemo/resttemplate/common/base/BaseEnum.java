package com.mydemo.resttemplate.common.base;

public enum BaseEnum implements BaseError {
    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400", "请求的数据格式不符!"),
    NOT_AUTHENTICATION("401", "没有认证"),
    NOT_PERMISSION("403", "没有权限访问"),
    NOT_FOUND("404", "未找到该资源"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503", "服务器正忙，请稍后再试!"),
    PARAM_ERROR("100100", "参数错误");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String msg;

    BaseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
