package com.example.hrms.entities.dtos;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationAddDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="resume_id")
	private int resumeId;
	
	@Column(name="school_name")
	@NotBlank(message="Okul adı boş geçilemez!!!")
	private String schoolName;
	

	@Column(name="school_department")
	@NotBlank(message = "Departman boş geçilemez!!!")
	private String schoolDepartment;
	
	@Column(name="starting_date")
	private Date startingDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="create_date")
	private Date createDate;	
	
	@Column(name="graduate_type_id")
	private int graduateTypeId;
}
