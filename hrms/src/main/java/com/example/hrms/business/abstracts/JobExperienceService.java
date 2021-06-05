package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	DataResult<List<JobExperience>> getAll();
	
	Result add(JobExperience jobExperience);
	
	//For sortable
	DataResult<List<JobExperience>> getAllSortedDesc();
}
