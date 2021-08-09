package com.project.customer.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString
@Document (collection = "customer")
public class Customer {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String numberDocument;
	
	private String firstName;
	private String lastName;
	private Date birthday;
	private String address;
	private String customerType;

}