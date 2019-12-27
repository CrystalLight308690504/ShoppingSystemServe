package com.onlineshop;

import com.onlineshop.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author CrystalLight
 * @Date 2019/12/26 9:17
 * @Version 1.0
 * @Description
 **/

@SpringBootApplication(scanBasePackages = "com.onlineshop")
public class ShoppingCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCarApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
