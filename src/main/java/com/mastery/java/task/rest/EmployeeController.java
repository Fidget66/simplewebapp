package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.api.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping(value = "/employee")
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @GetMapping(value = "/employee/{id}")
    public Employee read(@PathVariable("id") long id){
        return service.readById(id);
    }

    @DeleteMapping(value = "/employee/{id}")
    public void deleteByID(@PathVariable("id") long id){
        service.deleteById(id);
    }

    @GetMapping(value = "/employees")
    public List<Employee> showAll(){
        return service.readAll();
    }

    @PutMapping(value = "/employee")
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }
}
