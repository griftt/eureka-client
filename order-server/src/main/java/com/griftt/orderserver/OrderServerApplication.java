package com.griftt.orderserver;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker*/
//代替上面三个
@SpringCloudApplication()
@EnableHystrixDashboard //熔断器的可视化面板
@ComponentScan(basePackages ={"com.griftt"})
@EnableJpaRepositories(basePackages = {"com.griftt"})
@EntityScan(basePackages = "com.griftt")
@EnableFeignClients(basePackages = {"com.griftt.productclient.client"})
//引入tcc
@Import(SpringCloudConfiguration.class)
public class OrderServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }


    /**
     * 查看接口异常信息
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

    /**
     * 1.2、使用Spring Cloud的约束
     * 服务提供方Controler必须添加@Compensable注解；
     * 不允许对Feign/Ribbon/RestTemplate等HTTP请求自行进行封装，但允许拦截；
     * 如果需要定制instanceId, 格式必须为${ip}:${自行指定}:${port}；
     * 0.5.x版本仅支持Spring Boot 2.x、Spring Cloud 2.x版本；
     */
}
