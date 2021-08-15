package com.example.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_education")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity=Resume.class)
	@JoinColumn(name="resume_id", referencedColumnName="id", nullable = false)
	private Resume resume;
	
	@Column(name="school_name")
	@NotNull()
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
	private LocalDate createDate = LocalDate.now();	
	

	@ManyToOne(targetEntity = GraduateType.class)
	@JoinColumn(name="graduate_type_id", referencedColumnName="id", nullable = false)
	private GraduateType graduateType;
	
}
