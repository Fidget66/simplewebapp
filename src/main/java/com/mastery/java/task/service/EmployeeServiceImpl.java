package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exception.EntityIsNotPresentException;
import com.mastery.java.task.service.api.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Employee create(Employee employee) {
        employee.setEmployeeId(0L);
        return employeeDao.save(employee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Employee update(Employee employee) {
        Employee updatedEmployee = readById(employee.getEmployeeId());
        if (Objects.nonNull(employee.getFirstName()) && !employee.getFirstName().isEmpty()){
            updatedEmployee.setFirstName(employee.getFirstName());
        }
        if (Objects.nonNull(employee.getLastName()) && !employee.getLastName().isEmpty()){
            updatedEmployee.setLastName(employee.getLastName());
        }
        if (Objects.nonNull(employee.getDateOfBirth())){
            updatedEmployee.setDateOfBirth(employee.getDateOfBirth());
        }
        if (Objects.nonNull(employee.getJobTitle()) && !employee.getJobTitle().isEmpty()){
            updatedEmployee.setJobTitle(employee.getJobTitle());
        }
        return employeeDao.save(updatedEmployee);
    }

    @Override
    public Employee readById(long id) {
        return employeeDao.findById(id).orElseThrow(()->new EntityIsNotPresentException(""+id));
    }

    @Override
    public List<Employee> readAll() {
        return StreamSupport
                .stream(employeeDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(long id) {
        employeeDao.deleteById(id);
    }
}
