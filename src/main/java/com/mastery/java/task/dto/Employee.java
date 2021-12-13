package com.mastery.java.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotEmpty(message = "Name can't be null")
    @Pattern(regexp = "[a-zA-Z]*",message = "Only letters are allowed")
    private String firstName;
    @NotEmpty(message = "Last name can't be null")
    @Pattern(regexp = "[a-zA-Z]*",message = "Only letters are allowed")
    private String lastName;
    @Min(value = 1)
    private Long departmentId;
    @NotBlank(message = "Job title can't be null")
    private String jobTitle;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Past(message = "Date must be in the past")
    private LocalDate dateOfBirth;
}
