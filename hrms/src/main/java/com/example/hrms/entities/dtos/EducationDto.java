package com.example.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private boolean status;
}
