package com.example.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.example.hrms.business.abstracts.FavoriteJobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.FavoriteJobPosting;
import com.example.hrms.entities.dtos.FavoriteJobPostingAddDto;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/favoritejobpostings/")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class FavoriteJobPostingsController {
	private final FavoriteJobPostingService favoriteJobPostingService;
	
	@GetMapping("getall")
	public DataResult<List<FavoriteJobPosting>> getAll(){
		return favoriteJobPostingService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody FavoriteJobPosting favoriteJobPosting) {
		return favoriteJobPostingService.add(favoriteJobPosting);
	}
	
	@PostMapping("addFavoriteJobPostingDto")
	public Result addFavoriteJobPostingDto(FavoriteJobPostingAddDto favoriteJobPostingAddDto) {
		return favoriteJobPostingService.addFavoriteJobPostingDto(favoriteJobPostingAddDto);
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
