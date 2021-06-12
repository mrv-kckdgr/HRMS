package com.example.hrms.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	JobPosting getById(int id);
	
	JobPosting getByNumberOfPosition(int numberOfPosition);
	
	JobPosting getByMinSalaryAndMaxSalary(double minSalary, double maxSalary);
	
	JobPosting getByJobPosition(int jobPositionId);
	
	JobPosting getByEmployer_Id(int employerId);
	
	List<JobPosting> getByMinSalaryOrMaxSalary(double minSalary, double maxSalary);
	
	List<JobPosting> getByCity(int cityId);
	
	List<JobPosting> getByCity_IdIn(List<Integer> cities);
	
	List<JobPosting> getByApplicationDeadlineContains(Date applicationDeadline);
	
	List<JobPosting> getByMinSalaryStartsWith(double minSalary);
	
	List<JobPosting> getByMinSalaryEndsWith(double maxSalary);
	
	List<JobPosting> getByStatus(boolean status);
	
	//JPQL
	@Query("From JobPosting where city.id=:cityId and jobPosition.id=:jobPositionId")
	List<JobPosting> getByCity_IdAndJobPosition_Id(int cityId, int jobPositionId);
	
	@Query("From JobPosting where employer.companyName=:companyName and jobPosition.position=:position and numberOfPosition=:numberOfPosition and releaseDate=:releaseDate and applicationDeadline=:applicationDeadline and status=:status")
	List<JobPosting> getByCompanyNameAndPositionAndNumberOfPositionAndReleaseDateAndApplicationDeadlineAndStatus(String companyName, String position, int numberOfPosition, Date releaseDate, Date applicationDeadline, boolean status);

	@Query("From JobPosting where id=:id and status=:false")
	Result closeJobPosting(int id);
	
	@Query("From JobPosting where employer.id=:employerId and status=:status")
	List<JobPosting> getByEmployer_Id(int employerId, boolean status);
	
	//List<JobPosting> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
	
}
