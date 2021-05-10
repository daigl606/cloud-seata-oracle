package com.cebbank.service1;

import com.alibaba.cloud.seata.feign.SeataFeignClientAutoConfiguration;
import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@MapperScan("com.cebbank.service1.mapper")
@SpringBootApplication(exclude = {SeataFeignClientAutoConfiguration.class})
@EnableAutoDataSourceProxy
@EnableDiscoveryClient
public class Service1Application {

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

}
