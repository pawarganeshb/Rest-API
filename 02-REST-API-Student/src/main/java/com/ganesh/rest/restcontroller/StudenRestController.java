package com.ganesh.rest.restcontroller;

import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.rest.entities.Institude;
import com.ganesh.rest.entities.Studnet;

@RestController
@RequestMapping("/students")
public class StudenRestController {

	@GetMapping("/one")
	public ResponseEntity<Studnet> getStudent() {
		Institude institude = new Institude(1, "MGM");
		Studnet student = new Studnet(101, "Jone", 7540.15, Set.of("Math", "Physics", "Chemistri"),
				Map.of("Math", 90, "Phys", 74), institude);
		return new ResponseEntity<Studnet>(student, HttpStatus.OK);
	}

	@GetMapping("/institude")
	public ResponseEntity<Institude> getInstitude() {
		Institude institude = new Institude(1, "MGM");
		return new ResponseEntity<Institude>(institude, HttpStatus.OK);
	}

}
