package com.ganesh.rest.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.rest.model.Address;
import com.ganesh.rest.model.Employee;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		String emp = employee.toString();
		ResponseEntity<String> response = new ResponseEntity<String>(emp, HttpStatus.OK);
		return response;
	}

	@GetMapping("/one")
	public ResponseEntity<Employee> getEmployee() {
		Employee employee = new Employee(101, "Ganesh Pawar", 45000.00, new Address(119, "Pune"), List.of("P1", "P2"),
				Map.of("P1", 101));
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<String> getNameWithID(@RequestParam Integer id, @RequestParam String name) {
		String responseMessage = "ID: " + id + ", Name: " + name;
		return ResponseEntity.ok(responseMessage);
	}

	@PostMapping("/head")
	public String readHeader(@RequestHeader(required = false) String dept, @RequestHeader("Content-Type") String type,
			@RequestBody String myData) {

		return "Hello Head: " + dept + "," + type + ",Body:" + myData;
	}
}
