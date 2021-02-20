package com.javapub.passcode.passcodeuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableDiscoveryClient 开启服务注册与发现功能
 */
@EnableFeignClients(basePackages = "com.javapub.passcode.passcodeuser.feign")
@EnableDiscoveryClient
@MapperScan("com.javapub.passcode.passcodeuser.dao")
@SpringBootApplication
public class PasscodeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasscodeUserApplication.class, args);
    }

}
