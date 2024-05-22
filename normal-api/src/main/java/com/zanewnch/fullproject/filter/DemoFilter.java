package com.zanewnch.fullproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/*
@ServletComponentScan is used to support the filter to a spring boot project.
 */
@Order(1)
//@ServletComponentScan
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    /*
    init and destroy method have default method content, so it is not necessary to override them.
     */

    /*
    Init method only invoke once when the server is started.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init the filter ...");
        Filter.super.init(filterConfig);
    }

    /*
    Destroy method only invoke once when the server is closed.
     */
    @Override
    public void destroy() {
        System.out.println("Destroy the filter...");
        Filter.super.destroy();
    }

    /*
    Invoke when intercept the request
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Intercept the request...");

        /*
        The action before the controller
         */


        /*
        make it available to continue to controller
         */
        filterChain.doFilter(servletRequest, servletResponse);

        /*
        The action after the controller

        Only the actions below the doFilter method would be invoked after finishing the controller.
         */





    }
}
