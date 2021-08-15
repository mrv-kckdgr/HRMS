package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.concretes.Technology;
import com.example.hrms.entities.dtos.TechnologyAddDto;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
	Technology getById(int id);
	
	List<Technology> getByResume_Id(int resumeId);
	
	//TechnologyAddDto getById(int id);
	
	
}
