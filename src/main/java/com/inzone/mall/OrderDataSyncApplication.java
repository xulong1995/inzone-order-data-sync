package com.inzone.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: TODO
 * @author: xulong
 * @date: 2023年03月02日9:22
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.inzone.mall.*.mapper")
public class OrderDataSyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderDataSyncApplication.class, args);
    }
}
