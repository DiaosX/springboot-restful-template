package com.mydemo.resttemplate.common.base;


/**
 * @Author yst
 * @Date 2021/10/27 10:11 上午
 * @Version 1.0
 * @Desc 基础错误接口
 */
public interface BaseError {

    /**
     * 返回码
     */
    String getCode();

    /**
     * 错误描述
     */
    String getMsg();

    default void throwEx(String errMsg) {
        throw new BaseException(this.getCode(), errMsg);
    }

    default void throwEx() {
        throw new BaseException(this);
    }

    default BaseException asError() {
        return new BaseException(this);
    }

    default BaseException asError(String errMsg) {
        return new BaseException(this.getCode(), errMsg);
    }

    default BaseResp asResult() {
        return BaseResp.error(this);
    }

    default BaseResp asResult(String errMsg) {
        return BaseResp.error(this.getCode(), errMsg);
    }

}
