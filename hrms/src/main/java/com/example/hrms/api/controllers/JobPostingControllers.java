package com.example.hrms.api.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("/api/jobpostings/")
@CrossOrigin
public class JobPostingControllers {
	private JobPostingService jobPostingService;

	public JobPostingControllers(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAllJobPosting();
	}
	
	@GetMapping("getjobpostingwithdetails")
	public DataResult<List<JobPostingDto>> getJobPostingWithDetails() {
		return this.jobPostingService.getJobPostingWithDetails();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobPosting jobPosting){
		return this.jobPostingService.add(jobPosting);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody JobPosting jobPosting){
		return this.jobPostingService.add(jobPosting);
	}
	
	@GetMapping("getByMinSalaryAndMaxSalary")
	public DataResult<JobPosting> getByMinSalaryAndMaxSalary(@RequestParam("minSalary") double minSalary, @RequestParam("maxSalary") double maxSalary){
		return this.jobPostingService.getByMinSalaryAndMaxSalary(minSalary, maxSalary);
	}
	
	@GetMapping("getByCityAndJobPosition")
	public DataResult<List<JobPosting>> getByCityAndJobPosition(@RequestParam("cityId") int cityId, @RequestParam("jobPositionId") int jobPositionId){
		return this.jobPostingService.getByCityAndJobPosition(cityId, jobPositionId);
	}
	
	@GetMapping("getByCompanyNameAndPositionAndNumberOfPositionAndReleaseDateAndApplicationDeadlineAndStatus")
	public DataResult<List<JobPosting>> getByCompanyNameAndPositionAndNumberOfPositionAndReleaseDateAndApplicationDeadlineAndStatus(
			@RequestParam("companyName") String companyName, @RequestParam("position") String position, @RequestParam("numberOfPosition") int numberOfPosition, @RequestParam("releaseDate")  Date releaseDate, @RequestParam("applicationDeadline") Date applicationDeadline, @RequestParam("status") boolean status) {
		return this.jobPostingService.getByCompanyNameAndPositionAndNumberOfPositionAndReleaseDateAndApplicationDeadlineAndStatus(companyName, position, numberOfPosition, releaseDate, applicationDeadline, status);
	}
	
	//Tüm aktif iş ilanlarının tarihe göre listelenmesi, pasif ise kullanıcıyı bilgilendirme
	@GetMapping("/getAllBySortedDesc")
	public DataResult<List<JobPosting>> getAllSorted(int pageNo, int pageSize){
		return this.jobPostingService.getAllSorted(pageNo, pageSize);
	}
	
	//Bir iş ilanını listeleme
	@GetMapping("/getById/{id}")	
	public DataResult<JobPosting> getById(@PathVariable int id){
		return this.jobPostingService.getById(id);
	}
	
	//Bir iş ilanını aktif ise pasif hale getirme
	@PostMapping("/closeJobPosting")
	public Result closeJobPosting(@RequestParam int id) {
		return this.jobPostingService.closeJobPosting(id);
	}
	
	//Bir firmaya ait tüm kayıtları listeleme
	@GetMapping("/getJobPositionByEmployerId")
	public DataResult<List<JobPosting>> getByEmployer_Id(int employerId, boolean status) {
		return this.jobPostingService.getByEmployer_Id(employerId, status);
	}
}
