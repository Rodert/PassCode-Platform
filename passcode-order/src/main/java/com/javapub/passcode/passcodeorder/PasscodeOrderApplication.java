package com.javapub.passcode.passcodeorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.javapub.passcode.passcodeorder.dao"})
@SpringBootApplication
public class PasscodeOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasscodeOrderApplication.class, args);
    }

}
