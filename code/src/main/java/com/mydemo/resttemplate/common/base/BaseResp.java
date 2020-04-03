package com.mydemo.resttemplate.common.base;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResp<T> {
    private boolean success;
    private String code;
    private String msg;
    private T data;

    public BaseResp() {

    }

    public BaseResp(IBaseEnum error) {
        this(error.getCode(), error.getMsg());
    }

    public BaseResp(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = false;
    }

    public BaseResp(String code, T data) {
        this.code = code;
        this.data = data;
        this.success = true;
    }

    /**
     * 成功
     *
     * @return
     */
    public static BaseResp success() {
        return BaseResp.success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static <T> BaseResp<T> success(T data) {
        return new BaseResp<>(BaseEnum.SUCCESS.getCode(), data);
    }

    /**
     * 失败
     */
    public static BaseResp error(IBaseEnum error) {
        return new BaseResp(error);
    }

    /**
     * 失败
     */
    public static BaseResp error(String code, String msg) {
        return new BaseResp(code, msg);
    }

    /**
     * 失败
     */
    public static BaseResp error(String message) {
        return new BaseResp("-1", message);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
