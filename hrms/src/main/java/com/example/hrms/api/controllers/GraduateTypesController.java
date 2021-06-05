package com.example.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.GraduateTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.GraduateType;

@RestController
@RequestMapping("/api/graduatetypes/")
public class GraduateTypesController {
	
	private GraduateTypeService graduateTypeService;

	@Autowired
	public GraduateTypesController(GraduateTypeService graduateTypeService) {
		super();
		this.graduateTypeService = graduateTypeService;
	}
	
	@GetMapping("getall")
	public DataResult<List<GraduateType>> getAll(){
		return this.graduateTypeService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody GraduateType graduateType) {
		return this.graduateTypeService.add(graduateType);
	}

}
