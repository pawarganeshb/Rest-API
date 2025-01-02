package com.ganesh.rest.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private Integer empId;
	private String empName;
	private Double empSalary;
	private Address address;
	private List<String> projects;
	private Map<String, Integer> duration;

	
}
