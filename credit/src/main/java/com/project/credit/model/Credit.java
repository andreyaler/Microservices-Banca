package com.project.credit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class Credit {
	
	@Id
	private String id;
	private String creditCardCode;
	private String creditCard;
	private String cardNumber;
	private String typeCard;

}