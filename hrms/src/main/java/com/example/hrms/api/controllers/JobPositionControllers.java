package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobPositionService;
import com.example.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions/")
public class JobPositionControllers {
	private JobPositionService jobPositionService;

	public JobPositionControllers(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("getall")
	public List<JobPosition> getAll(){
		return this.jobPositionService.getAll();
	}
}
