package com.ganesh.rest.entities;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studnet {
	@JsonIgnore
	private Integer id;
	private String name;
	private Double marks;
	private Set<String> subjects;
	@JsonProperty("Subject-Marks ")
	private Map<String, Integer> subjectMarks;
	private Institude institude;
}
