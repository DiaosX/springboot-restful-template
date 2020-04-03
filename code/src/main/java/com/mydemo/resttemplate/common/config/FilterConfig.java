//package com.mydemo.resttemplate.config;
//
//import com.mydemo.resttemplate.common.web.MyFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.setFilter(new MyFilter());
//        bean.addUrlPatterns("/*");
//        return bean;
//    }
//}
