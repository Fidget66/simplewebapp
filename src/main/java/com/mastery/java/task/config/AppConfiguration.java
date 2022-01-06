package com.mastery.java.task.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    public void startMigration(){
        Flyway flyway = Flyway
                .configure()
                .dataSource(url, user, password)
                .load();
        flyway.migrate();
    }

}
