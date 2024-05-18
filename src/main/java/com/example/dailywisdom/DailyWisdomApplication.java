package com.example.dailywisdom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DailyWisdomApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyWisdomApplication.class, args);
    }

}
