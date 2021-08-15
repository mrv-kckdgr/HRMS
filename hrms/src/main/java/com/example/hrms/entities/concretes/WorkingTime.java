package com.example.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jobposting_working_time")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobPostings"})
public class WorkingTime {
	public WorkingTime(int id) {
		super();
		this.id = id;
	}


	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="working_time")
	@NotBlank(message="Çalışma zamanı alanı boş geçilemez!!")
	private String workingTime;
	
	
	@OneToMany(mappedBy = "workingTime")
	private List<JobPosting> jobPostings;
}
