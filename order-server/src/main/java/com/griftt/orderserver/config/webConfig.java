package com.griftt.orderserver.config;

import com.griftt.orderserver.interceptor.BaseControllerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 项目的各种大配置 如拦截器
 */
@Configuration
public class webConfig extends WebMvcConfigurerAdapter {

/**
 * WebMvcConfigurationSupport  手动配置类
 */


//    以下WebMvcConfigurerAdapter 比较常用的重写接口
//    /** 解决跨域问题 **/
//    public void addCorsMappings(CorsRegistry registry) ;
//    /** 添加拦截器 **/
//    void addInterceptors(InterceptorRegistry registry);
//    /** 这里配置视图解析器 **/
//    /** 视图跳转控制器 **/
//    void addViewControllers(ViewControllerRegistry registry);
//    void configureViewResolvers(ViewResolverRegistry registry);
//    /** 配置内容裁决的一些选项 **/
//    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
//    /** 视图跳转控制器 **/
//    void addViewControllers(ViewControllerRegistry registry);
//    /** 静态资源处理 **/
//    void addResourceHandlers(ResourceHandlerRegistry registry);
//    /** 默认静态资源处理器 **/
//    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);


    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/");
    };*/
    /**
     *
     * 功能描述:
     *  配置静态资源,避免静态资源请求被拦截
     * @auther: Tt(yehuawei)
     * @date:
     * @param:
     * @return:
     */
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }
*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.err.println("添加拦截器");
        registry.addInterceptor(new BaseControllerInterceptor()).addPathPatterns("/**n");
        //super.addInterceptors(registry);
    }
    //原文：https://blog.csdn.net/weixin_41788754/article/details/82890515



}
