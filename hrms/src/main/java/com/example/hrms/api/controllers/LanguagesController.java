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

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.dtos.LanguageAddDto;

@RestController
@RequestMapping("/api/languages/")
@CrossOrigin
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Language>> getAll(){
		return this.languageService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody Language language) {
		return this.languageService.add(language);
	}
	
	@PostMapping("addLanguageDto")
	public Result addLanguageDto(@Valid @RequestBody LanguageAddDto languageAddDto) {		
		return this.languageService.addLanguageDto(languageAddDto);
	}
	
	@GetMapping("getByResumeId")
	public DataResult<List<Language>> getByResumeId(@RequestParam int resumeId){
		return this.languageService.getByResume_Id(resumeId);
	}
	
	@PostMapping("updateLanguageDto")
	public Result updateLanguageDto(@Valid @RequestBody LanguageAddDto languageAddDto) {
		return this.languageService.updateLanguageDto(languageAddDto);
	}
	
	@GetMapping("getbyid")
	public DataResult<Language> getById(@RequestParam int id) {
		return this.languageService.getById(id);
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
