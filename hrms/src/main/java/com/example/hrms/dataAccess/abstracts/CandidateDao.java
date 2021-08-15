package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.JobPosting;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	boolean existsByNationalNumber(String nationalNumber);
	
	Candidate getById(int id);
}
