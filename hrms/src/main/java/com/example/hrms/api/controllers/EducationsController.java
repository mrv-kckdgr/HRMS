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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.dtos.EducationAddDto;
import com.example.hrms.entities.dtos.EducationDto;
import com.example.hrms.entities.dtos.JobPostingAddDto;

@RestController
@RequestMapping("/api/education/")
@CrossOrigin
public class EducationsController {
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	};
	
	@GetMapping("getall")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody Education education) {
		return this.educationService.add(education);
	}
	
	@GetMapping("getallsorteddesc")
	public DataResult<List<Education>> getAllSortedDesc() {
		return this.educationService.getAllSortedDesc();
	}
	
	@GetMapping("geteducationwithdetails")
	public DataResult<List<EducationDto>> getEducationWithDetails() {
		return this.educationService.getEducationWithDetails();
	}
	
	@PostMapping("addEducationDto")
	public Result addEducationDto(@Valid @RequestBody EducationAddDto educationDto) {		
		return this.educationService.addEducationDto(educationDto);
	}
	
	@PostMapping("updateEducationDto")
	public Result updateEducationDto(EducationAddDto educationDto) {
		return this.educationService.updateEducationDto(educationDto);
	}
	
	@GetMapping("getByResumeId")
	public DataResult<List<Education>> getByResumeId(@RequestParam int resumeId){
		return this.educationService.getByResume_Id(resumeId);
	}
	
	@GetMapping("getbyid")
	public DataResult<Education> getById(int id) {
		return this.educationService.getById(id);
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
