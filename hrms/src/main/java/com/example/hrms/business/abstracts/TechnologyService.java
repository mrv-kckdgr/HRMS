package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Technology;
import com.example.hrms.entities.dtos.TechnologyAddDto;

public interface TechnologyService {
	DataResult<List<Technology>> getAll();
	
	Result add(Technology technology);
	
	Result addTechnologyDto(TechnologyAddDto technologyAddDto);
	
	DataResult<List<Technology>> getByResume_Id(int resumeId);
	
	DataResult<Technology> getById(int id);
	
	Result updateTechnologyDto(TechnologyAddDto technologyAddDto);
}
