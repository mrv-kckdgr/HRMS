package com.example.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.TechnologyService;
import com.example.hrms.core.utilities.results.DataResult;
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
}
