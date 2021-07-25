package com.example.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Email(message="Lütfen geçerli bir e-mail adresi giriniz!!!")
	@NotBlank(message = "Email alanı geçerlidir!!!")
	@Size(min = 6, max = 60)
	@Column(name="email")
	private String email;
	
	
	@NotBlank(message = "Parola alanı zorunludur!!!")
	@Size(min = 6, max = 12)
	@Column(name="password")
	private String password;
	
	@NotBlank(message = "Parola tekrar alanı zorunludur!!!")
	@Size(min = 6, max = 12)
	@Transient
	private String passwordRepeat;
	
}
