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

import com.example.hrms.business.abstracts.TechnologyService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Technology;
import com.example.hrms.entities.dtos.JobPostingAddDto;
import com.example.hrms.entities.dtos.TechnologyAddDto;

@RestController
@RequestMapping("/api/technologies/")
@CrossOrigin
public class TechnologiesController {
	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Technology>> getAll(){
		return this.technologyService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody Technology technology){
		return this.technologyService.add(technology);
	}
	
	@PostMapping("/addTechnologyDto")
	public Result addTechnologyDto(@Valid @RequestBody TechnologyAddDto technologyAddDto) {		
		return this.technologyService.addTechnologyDto(technologyAddDto);
	}
	
	@GetMapping("/getbyresumeid")
	public DataResult<List<Technology>> getByResume_Id(int resumeId) {
		return this.technologyService.getByResume_Id(resumeId);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Technology> getById(int id) {
		return this.technologyService.getById(id);
	}
	
	@PostMapping("/updateTechnologyDto")
	public Result updateTechnologyDto(@Valid @RequestBody TechnologyAddDto technologyAddDto) {
		return this.technologyService.updateTechnologyDto(technologyAddDto);
	}
	
	@GetMapping("/getbytechnologydtoid")
	public DataResult<TechnologyAddDto> getByTechnologyAddDto_Id(@RequestParam int id) {
		return this.technologyService.getByTechnologyAddDto_Id(id);
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
