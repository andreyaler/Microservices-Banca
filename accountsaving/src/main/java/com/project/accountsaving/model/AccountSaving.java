package com.project.accountsaving.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document (collection = "accountsaving")
@ToString
public class AccountSaving {

	@Id
	private String id;
	private String savingAccountCode;
	private String description;
	private String accountNumber;
	private String amount;
	private String documentNumber;
	
}