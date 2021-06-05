package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.dtos.EducationDto;

public interface EducationService {
	DataResult<List<Education>> getAll();
	
	Result add(Education education);
	
	DataResult<List<Education>> getAllSortedDesc();
	
	Result add(EducationDto educationDto);
}
