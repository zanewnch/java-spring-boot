package com.zanewnch.fullproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@Order(2)
@Slf4j
//@ServletComponentScan
//@WebFilter(urlPatterns = "/*")
public class NextTestFilter implements Filter {
    /*
    Destroy and init method have default method content, so it is not necessary to override them.
     */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        return;
    }
}
