package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.jupiter.api.Test;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@Sql("classpath:data-test.sql")
class EmployeeServiceImplTestIT {

//    @ClassRule
//    public static PostgreSQLContainer postgreSQLContainer = TestContainerConfig.getInstance();
//
//    @Autowired
//    private  EmployeeServiceImpl service;
//
//    @Test
//    void createEmployee_thenReturnEmployee() {
//        Employee newEmployee = Employee.builder()
//                .firstName("TestCreate")
//                .lastName("TestSurName")
//                .dateOfBirth(LocalDate.now())
//                .gender(Gender.MALE)
//                .jobTitle("admin")
//                .build();
//        Employee actualEmpl = service.create(newEmployee);
//        Assertions.assertEquals(newEmployee, actualEmpl);
//    }

    @Test
    void update() {
    }

    @Test
    void readById() {
    }
}