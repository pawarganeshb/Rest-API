package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.EmployeeEntity;

public interface IEmployeeService {
	Optional<EmployeeEntity> getEmployeeById(Integer id);

	EmployeeEntity saveEmployee(EmployeeEntity employee);

	EmployeeEntity updateEmployee(Integer id, EmployeeEntity employee);

	void deleteEmployee(Integer id);
	List<EmployeeEntity> getAllEmployee();

	List<EmployeeEntity> findByEmployeeName(String name);
}
