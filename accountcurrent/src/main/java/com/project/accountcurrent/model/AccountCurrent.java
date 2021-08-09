package com.project.accountcurrent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document (collection = "accountcurrent")
@ToString
public class AccountCurrent {

	@Id
	private String id;
	private String accountCurrentCode;
	private String description;
	private String accountCurrentNumber;
	private String amount;
	private String documentNumber;
	
}