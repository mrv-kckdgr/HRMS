package com.example.hrms.entities.concretes;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_job_experiences")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	

	//@Column(name="resume_id")
	//private int resume_id;
	
	
	@Column(name="company_name")
	@NotBlank(message = "Şirket adı boş geçilemez!")
	private String companyName;
	
	//@Column(name="job_position_id")
	//private int jobPositionId;
	
	@Column(name="starting_date")
	private Date startingDate;
	
	@Column(name="end_date")
	private Date endDate;	
	
	@Column(name="create_date")
	private LocalDate createDate = LocalDate.now();
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity=Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@ManyToOne(targetEntity = JobPosition.class, fetch=FetchType.LAZY)
	@JoinColumn(name="job_position_id", referencedColumnName="id", nullable=false)
	private JobPosition jobPosition;
	
}
