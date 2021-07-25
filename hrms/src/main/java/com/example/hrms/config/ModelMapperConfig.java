package com.example.hrms.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.JobExperience;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.EducationAddDto;
import com.example.hrms.entities.dtos.JobExperienceAddDto;
import com.example.hrms.entities.dtos.JobPostingAddDto;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.addMappings(jobPostingAddDtoMap);	
		modelMapper.addMappings(educationAddDtoMap);	
		modelMapper.addMappings(jobExperienceAddDtoMap);	
		return modelMapper;
	}
	
	private final PropertyMap<JobPostingAddDto, JobPosting> jobPostingAddDtoMap = new PropertyMap<JobPostingAddDto, JobPosting>(){
		protected void configure() {
			map(source.getCityId(), destination.getCity().getId());
			map(source.getJobPositionId(), destination.getJobPosition().getId());
			map(source.getWorkingTimeId(), destination.getWorkingTime().getId());
			map(source.getWorkingTypeId(), destination.getWorkingType().getId());
			map(source.getEmployerId(), destination.getEmployer().getId());
		}
	};	
	
	private final PropertyMap<EducationAddDto, Education> educationAddDtoMap = new PropertyMap<EducationAddDto, Education>(){
		protected void configure() {
			map(source.getGraduateTypeId(), destination.getGraduateType().getId());		
			map(source.getResumeId(), destination.getResume().getId());		
		}
	};	
	
	private final PropertyMap<JobExperienceAddDto, JobExperience> jobExperienceAddDtoMap = new PropertyMap<JobExperienceAddDto, JobExperience>(){
		protected void configure() {
			map(source.getJobPositionId(), destination.getJobPosition().getId());		
			map(source.getResumeId(), destination.getResume().getId());		
		}
	};	
	
	
}
