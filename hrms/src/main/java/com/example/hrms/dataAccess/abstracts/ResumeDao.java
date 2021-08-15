package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeDto;


public interface ResumeDao extends JpaRepository<Resume, Integer> {
	//@Query("From JobPosting where city.id=:cityId and jobPosition.id=:jobPositionId")
	//List<ResumeDto> getAll();
	
	
	//@Query("Select new kodlamaio.northwind.entities.dtos.ResumeDto(p.id, p.productName, c.categoryName) From Category c inner join c.products p")
	//@Query("SELECT new com.example.hrms.entities.dtos.ResumeDto(r.id, r.githubLink, r.imageUrl, l.languageName, t.description FROM resumes r inner join r.languages l inner join r.technologies t") 
//			inner join resume_languages l
//			on r.id=l.resume_id
//			inner join resume_technologies t
//			on r.id=t.resume_id
//			inner join candidates c
//			on c.id=r.candidate_id
	//List<ResumeDto> getResumeWithDetails();
	
	@Query("From Resume where candidate.id=:candidateId")
	List<ResumeDto> getByCandidate_Id(int candidateId);
	
	//Resume getByCandidateId(int candidateId);
	
	ResumeDto getByCandidateId(int candidateId);
	
	Resume getById(int id);
	
}
