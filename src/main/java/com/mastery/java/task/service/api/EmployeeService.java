package com.mastery.java.task.service.api;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee update(Employee employee);
    Employee readById(long id);
    List <Employee> readAll();
    void deleteById(long id);
}
