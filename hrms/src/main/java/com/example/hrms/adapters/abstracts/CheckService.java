package com.example.hrms.adapters.abstracts;

import com.example.hrms.entities.concretes.Candidate;


public interface CheckService {
	boolean CheckIfRealPerson(Candidate candidate);
}
