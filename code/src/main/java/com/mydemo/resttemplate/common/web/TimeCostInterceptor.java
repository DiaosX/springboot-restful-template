package com.mydemo.resttemplate.common.web;

import cn.hutool.extra.servlet.ServletUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yst
 * @Description 请求耗时拦截器
 * @Date 2022/7/1 23:20
 * @Version 1.0
 */
@Slf4j
public class TimeCostInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        request.setAttribute("req-startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (Long) request.getAttribute("req-startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        String ip = ServletUtil.getClientIP(request);
        String requestURI = request.getRequestURI();
        String truePath = "";
        if (requestURI.equals("/error")) {
            truePath = (String) request.getAttribute("javax.servlet.error.request_uri");
        }
        log.info(requestURI + " 耗时: " + executeTime + "毫秒" + " "
                + JSON.toJSONString(request.getParameterMap()) + " " + ip + " " + request.getLocalPort() + " " + truePath);
    }
}
