package com.example.hrms.entities.dtos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingAddDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="job_position_id")
	private int jobPositionId;
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="number_of_position")
	private int numberOfPosition;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="release_date")
	private Date releaseDate;

	@Column(name="working_time_id")
	private int workingTimeId;
	
	@Column(name="working_type_id")
	private int workingTypeId;
}
