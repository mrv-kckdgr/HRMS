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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.hrms.business.abstracts.ResumeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeDto;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumesController {
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Resume>> getAll(){
		return this.resumeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}
	
	@PutMapping("/upload")
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam int resumeId) {
		return this.resumeService.saveImage(file, resumeId);
	}
	
	@GetMapping("/getresumewithdetails")
	public DataResult<List<ResumeDto>> getResumeWithDetails() {
		return this.resumeService.getResumeWithDetails();
	}
	
	@PostMapping("addresumedto")
	public Result addResumeDto(@RequestBody ResumeDto resumeDto) {
		return this.resumeService.addResumeDto(resumeDto);
	}
	
	@GetMapping("getbycandidateid")
	public DataResult<List<ResumeDto>> getByCandidate_Id(@RequestParam int candidateId) {
		return this.resumeService.getByCandidate_Id(candidateId);
	}
	
//	@GetMapping("getByCandidateIdSingleResume")
//	public DataResult<Resume> getByCandidateId(int candidateId) {	
//		return this.resumeService.getByCandidateId(candidateId);
//	}
	
	@GetMapping("getByCandidateIdResumeDetail")
	public DataResult<ResumeDto> getByCandidateId(@RequestParam int candidateId) {
		return this.resumeService.getByCandidateId(candidateId);
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
