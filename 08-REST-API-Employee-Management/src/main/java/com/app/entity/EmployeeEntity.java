package com.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Name cannot be empty")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String name;

	@Column(name = "dob")
	@Past(message = "Date of Birth must be a past date")
	private LocalDate dob;

	@NotBlank(message = "Contact number cannot be empty")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid contact number")
	private String contact;

	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Address cannot be empty")
	private String address;

	@NotBlank(message = "Department cannot be empty")
	private String department;

	@NotNull(message = "Salary cannot be null")
	@Min(value = 10000, message = "Salary must be at least 10,000")
	@Max(value = 2000000, message = "Salary cannot exceed 2,000,000")
	private Double salary;
}
