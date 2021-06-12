package com.example.hrms.entities.dtos;

import java.util.List;


import com.example.hrms.entities.concretes.JobExperience;
import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.concretes.Technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
	private int id;
	private int candidateId;
	private String githubLink;
	private String linkedlnLink;
	private String imageUrl;
	private String description;
	private String languageName;
	private List<JobExperience> jobExperiences;
	private List<Technology> technologies;
	private List<Language> languages;
}
