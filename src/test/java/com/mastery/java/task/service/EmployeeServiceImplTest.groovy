package com.mastery.java.task.service

import com.mastery.java.task.dao.EmployeeDao
import com.mastery.java.task.dto.Employee
import com.mastery.java.task.dto.Gender
import spock.lang.Specification
import java.time.LocalDate
import java.util.stream.Collectors
import java.util.stream.Stream

class EmployeeServiceImplTest extends Specification {

    EmployeeDao employeeDao = Mock(EmployeeDao)
    EmployeeServiceImpl service

    def setup(){
        service = new EmployeeServiceImpl(employeeDao, message, producer)
    }

    def "Create user"() {
        given: "prepare employee"
        def newUser = Employee.builder()
                .firstName("Test1")
                .lastName("LastName")
                .gender(Gender.MALE)
                .build()

        when: "receive employee"
        def returnEmployee = service.create(newUser)

        then: "check returned employee"
        1*employeeDao.save(newUser) >> newUser
        returnEmployee.employeeId == newUser.employeeId
        returnEmployee.firstName == newUser.firstName
        returnEmployee.lastName == newUser.lastName
        returnEmployee.gender == newUser.gender
    }

    def "Update"() {
        given: "prepare employee"
        def newEmpl = Employee.builder()
                .employeeId(1)
                .firstName("Test1")
                .lastName("LastName")
                .dateOfBirth(LocalDate.now())
                .jobTitle("admin")
                .build()

        when: "receive employee"
        def returnEmployee = service.update(newEmpl)

        then: "check returned employee"
        1*employeeDao.findById(1) >> Optional.of(newEmpl)
        1*employeeDao.save(newEmpl) >> newEmpl
        returnEmployee.employeeId == newEmpl.employeeId
        returnEmployee.firstName == newEmpl.firstName
        returnEmployee.lastName == newEmpl.lastName
        returnEmployee.gender == newEmpl.gender
    }

    def "ReadById"() {
        given: "prepare employee"
        def newEmpl = Employee.builder()
                .employeeId(1)
                .firstName("Test1")
                .lastName("LastName")
                .dateOfBirth(LocalDate.now())
                .jobTitle("admin")
                .build()

        when: "receive employee"
        def returnEmployee = service.readById(1)

        then: "check returned employee"
        1*employeeDao.findById(1) >> Optional.of(newEmpl)
        returnEmployee.employeeId == newEmpl.employeeId
        returnEmployee.firstName == newEmpl.firstName
        returnEmployee.lastName == newEmpl.lastName
        returnEmployee.gender == newEmpl.gender
    }

    def "ReadAll"() {
        given: "prepare employee"
        def emplList = Stream
                .generate(() -> new Employee())
                .limit(3)
                .collect(Collectors.toList())

        when: "receive employee"
        def returnEmployeeList = service.readAll()

        then: "check returned employee"
        1*employeeDao.findAll() >> emplList
        returnEmployeeList.size() == 3
        returnEmployeeList == emplList
    }

    def "DeleteById"() {
        given: "prepare employee"
        def id = 1

        when: "receive employee"
        service.deleteById(id)

        then: "check returned employee"
        1*employeeDao.deleteById(id)
    }
}
