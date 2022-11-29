package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            for(int i = 0;i<200;i++){
                Random rdbool= new Random();
                int distance = (int) ((Math.random() * (2000 - 5)) + 5);
                Student bill = new Student(
                        distance*100,
                        5000,
                        rdbool.nextBoolean(),
                        2000
                );
                repository.save(bill);
            }
        };
    }
}
