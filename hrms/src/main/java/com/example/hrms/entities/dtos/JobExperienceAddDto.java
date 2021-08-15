package com.example.hrms.entities.dtos;

import java.sql.Date;
import java.time.LocalDate;

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
public class JobExperienceAddDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	

	@Column(name="resume_id")
	private int resumeId;	
	
	@Column(name="company_name")
	@NotBlank(message = "Şirket adı boş geçilemez!")
	private String companyName;
	
	@Column(name="job_position_id")
	private int jobPositionId;
	
	@Column(name="starting_date")
	private Date startingDate;
	
	@Column(name="end_date")
	private Date endDate;	
	
	@Column(name="create_date")
	private LocalDate createDate = LocalDate.now();
}
