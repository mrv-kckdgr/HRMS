package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.Language;

public interface EducationDao extends JpaRepository<Education, Integer> {

	Education getById(int id);
	
	List<Education> getByResume_Id(int resumeId);
}
