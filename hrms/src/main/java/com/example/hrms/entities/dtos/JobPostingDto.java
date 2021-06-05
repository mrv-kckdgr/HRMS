package com.example.hrms.entities.dtos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.hrms.entities.concretes.City;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.JobPosition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
	
	//@Column(name="city_id")
	//private int cityId;
	
	//@Column(name="job_position_id")
	//private int jobPositionId;
	
	//@Column(name="employer_id")
	//private int employerId;	

	private int numberOfPosition;
	private Date applicationDeadline;
	private Boolean status;	
	private Date releaseDate;	
	//private City cityCityName;		
	private JobPosition jobPositionPosition;	
	private Employer employerCompanyName;
}
