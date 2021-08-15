package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);
	
	Result loginEmployer(String email, String password);
	
	DataResult<Employer> getById(int id);
	
	Result update(Employer employer);
}
