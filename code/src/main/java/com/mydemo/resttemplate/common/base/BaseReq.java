package com.mydemo.resttemplate.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author yst
 * @Description 基础请求类
 * @Date 2022/6/1 22:44
 * @Version 1.0
 */
@Data
public class BaseReq implements Serializable {
    /**
     * 请求ID
     */
    protected String requestId;
    protected String openId;
    protected String accessToken;
    /**
     * 请求时间戳，毫秒
     */
    protected String timestamp;

}
