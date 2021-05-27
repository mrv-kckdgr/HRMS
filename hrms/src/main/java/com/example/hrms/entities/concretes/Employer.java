package com.example.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@Entity
public class Employer extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "Şirket alanı zorunludur.")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message = "Web adres alanı zorunludur.")
	@Column(name="web_address")
	private String webAddress;
	
	@NotBlank(message = "Telefon Numarası alanı zorunludur.")
	@Column(name="phone_number")
	private String phoneNumber;
}