package com.javapub.passcode.passcodeproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @EnableDiscoveryClient 开启服务注册与发现功能
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PasscodeProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasscodeProductApplication.class, args);
    }

}
