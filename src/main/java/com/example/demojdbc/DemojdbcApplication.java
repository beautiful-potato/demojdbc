package com.example.demojdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.example.demojdbc.dao")
public class DemojdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemojdbcApplication.class, args);
    }

}
