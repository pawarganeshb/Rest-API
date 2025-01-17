package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.EmployeeEntity;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Optional<EmployeeEntity> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public EmployeeEntity updateEmployee(Integer id, EmployeeEntity employee) {
		return employeeRepository.findById(id).map(existingEmployee -> {
			existingEmployee.setName(employee.getName());
			existingEmployee.setDob(employee.getDob());
			existingEmployee.setContact(employee.getContact());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setAddress(employee.getAddress());
			existingEmployee.setDepartment(employee.getDepartment());
			existingEmployee.setSalary(employee.getSalary());
			return employeeRepository.save(existingEmployee);
		}).orElse(null);
	}

	@Override
	public void deleteEmployee(Integer id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		}
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public List<EmployeeEntity> findByEmployeeName(String name) {
		return employeeRepository.findByName(name);
	}

	
}
