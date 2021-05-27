package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	
	Result add(Candidate candidate);
}
