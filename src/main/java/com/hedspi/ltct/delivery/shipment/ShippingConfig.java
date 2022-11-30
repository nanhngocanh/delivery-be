package com.example.demo.shipment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ShippingConfig {
    @Bean
    CommandLineRunner commandLineRunner(ShippingRepository repository){
        return args -> {
//            for(int i = 0;i<200;i++){
//                Random rdbool= new Random();
//                int distance = (int) ((Math.random() * (2000 - 5)) + 5);
//                Shipping bill = new Shipping(
//                        rdbool.nextBoolean(),
//                        distance*100
//                );
//                repository.save(bill);
//            }
        };
    }
}
