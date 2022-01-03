package com.mastery.java.task.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class AppConfiguration {

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.username}")
    private String user;

    @Bean
    public void startMigration(){
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:postgresql://localhost:5432/employeedb", user, password)
                .load();
        flyway.migrate();
    }

    @Bean
    public SimpleMailMessage getSimpleMailMessage(){
        return new SimpleMailMessage();
    }

}
