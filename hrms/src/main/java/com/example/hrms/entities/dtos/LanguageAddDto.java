package com.example.hrms.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageAddDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="resume_id")
	private int resumeId;
	
	@Column(name="language_name")
	@NotBlank(message = "Dil adı boş geçilemez!!!")
	private String languageName;
	
	@Column(name="language_level")
	//@NotEmpty(message = "Dil seviyesi boş geçilemez!!!")
	//@Size(min = 1)
	private char languageLevel;
	
	@Column(name="create_date")
	private LocalDate createDate = LocalDate.now();
}
