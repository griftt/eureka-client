package com.griftt.orderserver.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "mvc")
@Component
public class BaseFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        System.out.println("过滤器路径："+httpServletRequest.getRequestURI());
         chain.doFilter(httpServletRequest,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("过滤器初始化");
    }

    public BaseFilter(){
        System.err.println("filter");
    }
}
