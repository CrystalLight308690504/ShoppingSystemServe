package com.onlineshop;

import com.onlineshop.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author CrystalLight
 * @Date 2019/12/24 18:34
 * @Version 1.0
 * @Description
 **/

@SpringBootApplication(scanBasePackages = "com.onlineshop")
public class OrderApplication {

        public static void main(String[] args) {
            SpringApplication.run(OrderApplication.class,args);
        }

        @Bean
        public IdWorker idWorker(){
            return new IdWorker();
        }

}
