package com.example.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")


public class Candidate extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	
	
	@NotNull(message = "İsim alanı zorunludur.")
	@Column(name="first_name")	
	private String firstName;
	
	@NotNull(message = "Soyad alanı zorunludur.")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message = "TC alanı zorunludur.")
	@Column(name="national_number")
	@Size(max=11)
	private String nationalNumber;
	
	
	@NotNull(message = "Doğum Tarihi alanı zorunludur.")
	@Column(name="date_of_birth")
	private Date dateOfBirth; //1997-11-01
}
