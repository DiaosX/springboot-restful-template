package com.mydemo.resttemplate.common.component;

import com.alibaba.fastjson.JSON;
import com.mydemo.resttemplate.common.annotation.IgnoreResultWrapper;
import com.mydemo.resttemplate.common.base.BaseResp;
import com.mydemo.resttemplate.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @Author yst
 * @Description 全局结果包装处理器，将接口返回封装为统一的响应结构
 * @Date 2022/7/2 21:31
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        Method method = returnType.getMethod();
        Class<?> returnClazz = method.getReturnType();
        if (returnClazz == null) {
            return false;
        }
        //只对自己关心的api经行包装逻辑，其他任何的api应该忽略
        if (BaseController.class.isAssignableFrom(method.getDeclaringClass())) {
            //已经是统一返回包装类，无需再包装
            if (BaseResp.class == returnClazz || BaseResp.class.isAssignableFrom(returnClazz)) {
                return false;
            }
            if (method.isAnnotationPresent(IgnoreResultWrapper.class)) {
                return false;
            }
            //特殊场景下需要自定义返回类型，无需统一包装，如对接不同的第三方
            if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResultWrapper.class)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {


        if (body == null) {
            return BaseResp.success();
        }
        //如果是String类型
        if (returnType.getParameterType() == String.class || body instanceof String) {
            return JSON.toJSONString(BaseResp.success(body));
        }
        return BaseResp.success(body);
    }
}
