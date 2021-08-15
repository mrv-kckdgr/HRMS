package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.GraduateType;

public interface GraduateTypeDao extends JpaRepository<GraduateType, Integer> {
	boolean existsByDescription(String description);
	
	GraduateType getById(int id);
}
