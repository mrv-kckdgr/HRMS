package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployeeDao;
import com.example.hrms.entities.concretes.Employee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService{

	private final EmployeeDao employeeDao;
	
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(), "Listeleme başarılı");
	}

	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public DataResult<Employee> getById(int id) {
		return new SuccessDataResult<Employee>(employeeDao.getById(id), "Listeleme başarılı");
	}

	@Override
	public Result update(Employee employee) {
		Employee updatedEmployee = this.employeeDao.getById(employee.getId());
		System.out.println(updatedEmployee.getId());
		System.out.println(employee.getFirstName());
		updatedEmployee.setFirstName(employee.getFirstName());
		updatedEmployee.setLastName(employee.getLastName());
		updatedEmployee.setEmail(employee.getEmail());
		updatedEmployee.setPassword(employee.getPassword());
		employeeDao.save(updatedEmployee);
		return new SuccessResult("Güncelleme işlemi başarılı bir şekilde gerçekleştirildi");
	}

}
