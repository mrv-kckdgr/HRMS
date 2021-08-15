package com.example.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobExperience;
import com.example.hrms.entities.dtos.JobExperienceAddDto;

@RestController
@RequestMapping("/api/jobexperiences/")
@CrossOrigin
public class JobExperiencesController {
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}
	
	@GetMapping("getallsorteddesc")
	public DataResult<List<JobExperience>> getAllSortedDesc() {
		return this.jobExperienceService.getAllSortedDesc();
	}
	
	@PostMapping("/addJobExperienceDto")
	public Result addJobExperience(@Valid @RequestBody JobExperienceAddDto jobExperienceAddDto) {		
		return this.jobExperienceService.addJobExperienceDto(jobExperienceAddDto);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobExperience> getById(int id){
		return this.jobExperienceService.getById(id);
	}
	
	@PostMapping("/updateJobExperienceDto")
	public Result updateJobExperienceDto(@Valid @RequestBody JobExperienceAddDto jobExperienceAddDto) {
		return this.jobExperienceService.updateJobExperienceDto(jobExperienceAddDto);
	}
	
	@GetMapping("/getbyresumeid")
	
	public DataResult<List<JobExperience>> getByResume_Id(int resumeId) {
		return this.jobExperienceService.getByResume_Id(resumeId);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handlerValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları:");
		return errors;
		
	}
}
