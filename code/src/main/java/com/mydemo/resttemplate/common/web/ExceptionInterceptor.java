//package com.mydemo.resttemplate.common.web;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.security.auth.Subject;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Map;
//
////@Component
//public class ExceptionInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
////        String token = request.getParameter("token");
////        if (StringUtils.isNotEmpty(token)) {
////            Subject subject = ShiroUtil.getSubject(token);
////            if (subject != null && subject.isAuthenticated()) {
////                return true;
////            } else {
////                //返回校验token结果
////                returnJson(response);
////                // return false; //我做的时候返回数据后忘记return false了，所以导致异常
////            }
////        }
//
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//
//    private void returnJson(HttpServletResponse response) {
////        PrintWriter writer = null;
////        response.setCharacterEncoding("UTF-8");
////        response.setContentType("application/json; charset=utf-8");
////        try {
////            writer = response.getWriter();
////            Map<String, Object> result = PackageReturnResult.returnJson(400, "用户令牌token无效");
////            result.put("data", null);
////            writer.print(result);
////        } catch (IOException e) {
////            LoggerUtil.logError(ExceptionInterceptor.class, "拦截器输出流异常" + e);
////        } finally {
////            if (writer != null) {
////                writer.close();
////            }
////        }
//    }
//}
