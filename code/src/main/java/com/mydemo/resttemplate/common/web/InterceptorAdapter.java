//package com.mydemo.resttemplate.common.web;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
////@Configuration
//public class InterceptorAdapter extends WebMvcConfigurerAdapter {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new ExceptionInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(
//                        "/user/login/**",
//                        "/swagger-resources/**",
//                        "/user/register/**",
//                        "/shortMessage/**",
//                        "/user/makesure/**",
//                        "/user/has/**",
//                        "/attachment/**");
//        super.addInterceptors(registry);
//    }
//}
//
