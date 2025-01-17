package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	
	public List<EmployeeEntity> findByName(String name);
}
