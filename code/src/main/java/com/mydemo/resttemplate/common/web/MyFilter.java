package com.mydemo.resttemplate.common.web;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
