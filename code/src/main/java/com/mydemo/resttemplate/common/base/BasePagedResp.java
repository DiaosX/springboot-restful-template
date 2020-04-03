package com.mydemo.resttemplate.common.base;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasePagedResp<T> {
    private boolean success;
    private String code;
    private String msg;
    private BasePagedResult<T> pager;

    public BasePagedResp() {

    }

    public BasePagedResp(IBaseEnum error) {
        this(error.getCode(), error.getMsg());
    }

    public BasePagedResp(String code, String msg) {
        this.success = false;
        this.code = code;
        this.msg = msg;
    }

    public BasePagedResp(String code, BasePagedResult<T> pager) {
        this.code = code;
        this.pager = pager;
        this.success = true;
    }

    /**
     * 成功
     *
     * @param pager
     * @return
     */
    public static <T> BasePagedResp<T> success(BasePagedResult<T> pager) {
        return new BasePagedResp<>(BaseEnum.SUCCESS.getCode(), pager);
    }

    /**
     * 失败
     */
    public static BasePagedResp error(IBaseEnum error) {
        return new BasePagedResp(error);
    }

    /**
     * 失败
     */
    public static BasePagedResp error(String code, String msg) {
        return new BasePagedResp(code, msg);
    }

    /**
     * 失败
     */
    public static BasePagedResp error(String msg) {
        return new BasePagedResp("-1", msg);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
