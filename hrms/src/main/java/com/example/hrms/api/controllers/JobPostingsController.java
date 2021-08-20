package com.example.hrms.api.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingAddDto;
import com.example.hrms.entities.dtos.JobPostingDto;


@RestController
@RequestMapping("/api/jobpostings")
//@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobPostingsController {
	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAllJobPosting();
	}
	
	@GetMapping("/getjobpostingwithdetails")
	public DataResult<List<JobPostingDto>> getJobPostingWithDetails() {
		return this.jobPostingService.getJobPostingWithDetails();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobPosting jobPosting){
		return this.jobPostingService.add(jobPosting);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody JobPosting jobPosting){
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
	@GetMapping("/getbyid")	
	public DataResult<JobPosting> getById(@RequestParam int id){
		return this.jobPostingService.getById(id);
	}
	
	//Bir iş ilanını aktif ise pasif hale getirme
	@PostMapping("/closejobposting")
	public Result closeJobPosting(@Valid @RequestParam int id) {
		return this.jobPostingService.closeJobPosting(id);
	}
	
	//Bir firmaya ait tüm kayıtları listeleme
	@GetMapping("/getJobPositionByEmployerId")
	public DataResult<List<JobPosting>> getByEmployer_Id(int employerId, boolean status) {
		return this.jobPostingService.getByEmployer_Id(employerId, status);
	}
	
	@PostMapping("/addJobPostingDto")
	public Result addJobPosting(@Valid @RequestBody JobPostingAddDto jobPostingDto) {		
		return this.jobPostingService.addJobPosting(jobPostingDto);
	}
	
	@GetMapping("/getByStatus")
	public DataResult<List<JobPosting>> getByStatus(@RequestParam boolean status) {
		return this.jobPostingService.getByStatus(status);
	}
	
	//Bir iş ilanını onaylama (pasif durumdan aktif duruma getirme)
	@PostMapping("/activejobposting")
	public Result activeJobPosting(@Valid @RequestParam int id) {
		return this.jobPostingService.activeJobPosting(id);
	}
	
	@PostMapping("/updateJobPostingDto")
	public Result updateJobPosting(@Valid @RequestBody JobPostingAddDto jobPostingDto) {
		return this.jobPostingService.updateJobPosting(jobPostingDto);
	}
	
	
	@GetMapping("getByCityAndJobPositionAndWorkingTimeAndWorkingType")
	public DataResult<List<JobPosting>> getByCity_IdAndJobPosition_IdAndWorkingTime_IdAndWorkingType(int cityId,
			int jobPositionId, int workingTimeId, int workingTypeId) {
		return this.jobPostingService.getByCity_IdAndJobPosition_IdAndWorkingTime_IdAndWorkingType(cityId, jobPositionId, workingTimeId, workingTypeId);
	}		
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handlerValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları:");
		return errors;
		
	}
}
