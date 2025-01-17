package com.app.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.EmployeeEntity;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173") // Allow React frontend
public class EmployeeRestController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Integer id) {
		Optional<EmployeeEntity> employee = employeeService.getEmployeeById(id);
		return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
		List<EmployeeEntity> allEmployees = employeeService.getAllEmployee();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}

	// Search employees by name
	@GetMapping("/search/{name}")
	public ResponseEntity<List<EmployeeEntity>> searchEmployeesByName(@PathVariable String name) {
		List<EmployeeEntity> employees = employeeService.findByEmployeeName(name);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee) {
		EmployeeEntity savedEmployee = employeeService.saveEmployee(employee);
		return ResponseEntity.ok(savedEmployee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Integer id,
			@RequestBody EmployeeEntity employee) {
		EmployeeEntity updatedEmployee = employeeService.updateEmployee(id, employee);
		if (updatedEmployee != null) {
			return ResponseEntity.ok(updatedEmployee);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
}
