package com.mastery.java.task.config;

import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainerConfig extends PostgreSQLContainer<TestContainerConfig>{

    private static final String IMAGE_VERSION = "postgres:11.1";
    private static TestContainerConfig container;

    private TestContainerConfig() {
        super(IMAGE_VERSION);
    }

    public static TestContainerConfig getInstance() {
        if (container == null) {
            container = new TestContainerConfig().withUsername("Hi").withPassword("Hi");
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
    }
}
