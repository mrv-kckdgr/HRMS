package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	
	DataResult<Employee> getById(int id);
	
	Result add(Employee employee);
	
	Result update(Employee employee);
	
	
}
