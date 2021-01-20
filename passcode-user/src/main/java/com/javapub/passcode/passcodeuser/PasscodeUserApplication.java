package com.javapub.passcode.passcodeuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @EnableDiscoveryClient 开启服务注册与发现功能
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PasscodeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasscodeUserApplication.class, args);
    }

}
