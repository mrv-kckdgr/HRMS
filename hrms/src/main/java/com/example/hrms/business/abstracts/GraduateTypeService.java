package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.GraduateType;

public interface GraduateTypeService {
	
	DataResult<List<GraduateType>> getAll();
	
	Result add(GraduateType graduateType);
	
	DataResult<GraduateType> getById(int id);
}
