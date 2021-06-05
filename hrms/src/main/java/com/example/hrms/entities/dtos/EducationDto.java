package com.example.hrms.entities.dtos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.hrms.entities.concretes.GraduateType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	@JsonIgnore
	private int id;
	
	private int resumeId;
	private String schoolName;	
	
	private int graduateId;	
	
	private String schoolDepartment;	
	
	private Date startedDate;	
	
	private Date createDate;	
	
	private Date finishDate;	
	
	private boolean status;}
