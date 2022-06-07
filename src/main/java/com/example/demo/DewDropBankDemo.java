package com.example.demo;

import com.example.demo.config.DewdropConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DewDropBankDemo {

    public static void main(String[] args) {
        DewdropConfig.getInstance();
        SpringApplication.run(DewDropBankDemo.class, args);
    }

}
