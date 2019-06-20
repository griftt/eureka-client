package com.griftt.orderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker*/
//代替上面三个
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.griftt.common")
@ComponentScan(basePackages ={"com.griftt"})
@EnableJpaRepositories(basePackages = {"com.griftt.common"})
@EntityScan("com.griftt")
public class OrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }
}
