package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        properties = {"flyway.enabled=false", "spring.datasource.schema=classpath*:db/migration/V1__data-test",
        "spring.cloud.config.enabled=false"})
@ContextConfiguration(initializers = {EmployeeServiceImplTestIT.Initializer.class})
@Testcontainers
class EmployeeServiceImplTestIT {

    @Container
    public static PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("integration-tests-db")
            .withUsername("sa")
            .withPassword("sa");

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
    @Autowired
    private  EmployeeServiceImpl service;

    @Test
    void createEmployee_thenReturnEmployee() {
        Employee newEmployee = Employee.builder()
                .firstName("TestCreate")
                .lastName("TestSurName")
                .dateOfBirth(LocalDate.now().minusDays(30))
                .gender(Gender.MALE)
                .jobTitle("admin")
                .email("asdasd@adadssa.sad")
                .build();
        Employee actualEmpl = service.create(newEmployee);
        Assertions.assertNotNull(actualEmpl.getEmployeeId());
    }

    @Test
    void update() {
    }

    @Test
    void readById() {
    }
}