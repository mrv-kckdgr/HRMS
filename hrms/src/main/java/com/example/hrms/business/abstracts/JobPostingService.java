package com.example.hrms.business.abstracts;

import java.sql.Date;
import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();
	
	Result add(JobPosting jobPosting);
	
	Result update(JobPosting jobPosting);
	
	DataResult<JobPosting> getById(int id);
	
	DataResult<JobPosting> getByNumberOfPosition(int numberOfPosition);
	
	DataResult<JobPosting> getByMinSalaryAndMaxSalary(double minSalary, double maxSalary);
	
	DataResult<JobPosting> getByPositionId(int jobPositionId);
	
	//Tek bir firmanın tüm ilanlarını listelemek istersek
	DataResult<JobPosting> getByEmployerId(int employerId);
	
	DataResult<List<JobPosting>> getByMinSalaryOrMaxSalary(double minSalary, double maxSalary);
	
	DataResult<List<JobPosting>> getByCityId(int cityId);
	
	DataResult<List<JobPosting>> getByCityIdIn(List<Integer> cities);
	
	DataResult<List<JobPosting>> getByApplicationDeadlineContains(Date applicationDeadline);
	
	DataResult<List<JobPosting>> getByMinSalaryStartsWith(double minSalary);
	
	DataResult<List<JobPosting>> getByMinSalaryEndsWith(double maxSalary);	
	
	DataResult<List<JobPosting>> getByStatus(boolean status);
	
	DataResult<List<JobPosting>> getByCityAndJobPosition(int cityId, int jobPositionId);
	
	DataResult<List<JobPosting>> getByCompanyNameAndPositionAndNumberOfPositionAndReleaseDateAndApplicationDeadlineAndStatus(String companyName, String position, int numberOfPosition, Date releaseDate, Date applicationDeadline, boolean status);
	
	//Sort By Date
	DataResult<List<JobPosting>> getAllSorted(int pageNo, int pageSize);
	
	//İş ilanı pasifleştirme
	Result closeJobPosting(int id);
	
	//Bir firmaya ait tüm ilanları listeleme
	DataResult<List<JobPosting>> getByEmployer_Id(int employerId, boolean status);
}
