package com.project.fixedterm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString
@Document (collection = "fixedterm")
public class FixedTerm {
	
	@Id
	private String id;
	private String fixedTermCode;
	private String description;
	private String fixedTermNumber;
	private String amount;
	private String documentNumber;

}