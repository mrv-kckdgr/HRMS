package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.hrms.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer getById(int id);
	
	@Query("From Employer where updateEmployer is not null")
	List<Employer> getByUpdateEmployer();
}