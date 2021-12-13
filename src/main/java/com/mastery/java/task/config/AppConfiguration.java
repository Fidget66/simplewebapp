package com.mastery.java.task.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public void startMigration(){
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:postgresql://localhost:5432/employeedb", "postgres", "3784")
                .load();
        flyway.migrate();
    }

}
