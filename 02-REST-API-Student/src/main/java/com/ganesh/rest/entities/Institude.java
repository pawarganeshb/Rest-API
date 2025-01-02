package com.ganesh.rest.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institude {
	@JsonProperty("Institude ID")
	private Integer id;
	@JsonProperty("Institude Name ")
	private String name;

}
