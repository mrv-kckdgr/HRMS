package com.example.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeDto;

public interface ResumeService {
	
	DataResult<List<Resume>> getAll();
	
	Result add(Resume resume);
	
	Result saveImage(MultipartFile file, int resumeId);
	
	DataResult<List<Resume>> getAllResume();
	
	DataResult<List<ResumeDto>> getResumeWithDetails();
	
	DataResult<List<ResumeDto>> getByCandidate_Id(int candidateId);
	
	Result addResumeDto(ResumeDto resumeDto);
	
	//Bir adaya ait CV  görüntüleme
	//DataResult<Resume> getByCandidateId(int candidateId);
	
	//Bir adaya ait CV detay  görüntüleme
	DataResult<ResumeDto> getByCandidateId(int candidateId);
	
	Result updateResumeDto(ResumeDto resumeDto);
	
	DataResult<Resume> getById(int id);
}
