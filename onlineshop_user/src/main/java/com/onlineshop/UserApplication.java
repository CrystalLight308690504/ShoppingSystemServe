package com.onlineshop;

import com.onlineshop.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author CrystalLight
 * @Date 2019/12/19 9:04
 * @Version 1.0
 * @Description
 **/
@SpringBootApplication(scanBasePackages = "com.onlineshop")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
