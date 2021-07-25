package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.WorkingTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingtypes/")
//@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WorkingTypesController {

	private WorkingTypeService workingTypeService;

	@Autowired
	public WorkingTypesController(WorkingTypeService workingTypeService) {
		super();
		this.workingTypeService = workingTypeService;
	}
	
	@GetMapping("getall")
	public DataResult<List<WorkingType>> getAll() {	
		return this.workingTypeService.getAll();
	}
}
