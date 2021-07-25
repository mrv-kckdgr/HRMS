package com.example.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPostingDao;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingAddDto;
import com.example.hrms.entities.dtos.JobPostingDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor 
public class JobPostingManager implements JobPostingService {
	private final JobPostingDao jobPostingDao;
	private final DtoConverterService dtoConverterService;
	private final ModelMapper modelMapper;
	
	
	@Override
	public DataResult<List<JobPosting>> getAllJobPosting() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(), "Pozisyonlar listelendi");
	}	


	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı başarılı bir şekilde eklendi.");
	}
	
	@Override
	public Result update(JobPosting jobPosting) {
		jobPosting.setStatus(false);
		this.jobPostingDao.saveAndFlush(jobPosting);
		return new SuccessResult("İş ilanı başarılı bir şekilde güncellendi.");
	}
	
	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(jobPostingDao.getById(id), "Veri listelendi");
	}
	

	@Override
	public DataResult<JobPosting> getByNumberOfPosition(int numberOfPosition) {
		return new SuccessDataResult<JobPosting>(jobPostingDao.getByNumberOfPosition(numberOfPosition), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<JobPosting> getByMinSalaryAndMaxSalary(double minSalary, double maxSalary) {
		return new SuccessDataResult<JobPosting>(jobPostingDao.getByMinSalaryAndMaxSalary(minSalary, maxSalary), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<JobPosting> getByPositionId(int jobPositionId) {
		return new SuccessDataResult<JobPosting>(jobPostingDao.getByJobPosition(jobPositionId), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<JobPosting> getByEmployerId(int employerId) {
		return new SuccessDataResult<JobPosting>(jobPostingDao.getByEmployer_Id(employerId), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByMinSalaryOrMaxSalary(double minSalary, double maxSalary) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByMinSalaryOrMaxSalary(minSalary, maxSalary), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByCityId(int cityId) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByCity(cityId), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByCityIdIn(List<Integer> cities) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByCity_IdIn(cities), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByApplicationDeadlineContains(Date applicationDeadline) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByApplicationDeadlineContains(applicationDeadline), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByMinSalaryStartsWith(double minSalary) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByMinSalaryStartsWith(minSalary), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByMinSalaryEndsWith(double maxSalary) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByMinSalaryEndsWith(maxSalary), "İş ilanları başarılı bir şekilde listelendi");
	}

	//Aktif iş ilanlarının listesi
	@Override
	public DataResult<List<JobPosting>> getByStatus(boolean status) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByStatus(true));
	}

	@Override
	public DataResult<List<JobPosting>> getByCityAndJobPosition(int cityId, int jobPositionId) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByCity_IdAndJobPosition_Id(cityId, jobPositionId), "İş ilanları başarılı bir şekilde listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByCompanyNameAndPositionAndNumberOfPositionAndReleaseDateAndApplicationDeadlineAndStatus(
			String companyName, String position, int numberOfPosition, Date releaseDate, Date applicationDeadline, boolean status) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByCompanyNameAndPositionAndNumberOfPositionAndReleaseDateAndApplicationDeadlineAndStatus(companyName, position, numberOfPosition, releaseDate, applicationDeadline, status), "İstenilen filtrelere göre sistemdeki tüm aktif iş ilanları listelenmiştir");
	}
	
	@Override
	public DataResult<List<JobPosting>> getAllSorted(int pageNo, int pageSize){
		Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort), "Tarihe göre listeleme işlemi başarılı");
	}
	
	@Override	
	public Result closeJobPosting(int id) {
		JobPosting job = jobPostingDao.getById(id);
		if(job.getStatus()==false) {
			return new ErrorResult("İlan zaten pasif durumda!!!");
		}
		System.out.println(job.getId());
		System.out.println(job.getStatus());
		job.setStatus(false);
		this.jobPostingDao.save(job);		
		return new SuccessResult("İş ilanı başarılı bir şekilde pasif hale getirilmiştir.");
	}

	@Override
	public DataResult<List<JobPosting>> getByEmployer_Id(int employerId, boolean status) {
		//JobPosting job = jobPostingDao.getByEmployer_Id(employerId);
		//System.out.println(job.getId());
		//System.out.println(job.getEmployer());
		//if(job != null) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByEmployer_Id(employerId, status), "İlgili firmaya ait tüm kayıtlar listelenmiiştir.");
		//}
		//return new ErrorDataResult<List<JobPosting>>(null, "Girdiğiniz Şirkete ait iş ilanı bilgisi bulunamadı!!!");
	}

	@Override
	public DataResult<List<JobPostingDto>> getJobPostingWithDetails() {
		return new SuccessDataResult<List<JobPostingDto>>(dtoConverterService.dtoConverter(jobPostingDao.findAll(), JobPostingDto.class), "Listeleme Başarılı");
	}

	
	public Result addJobPosting(JobPostingAddDto jobPostingDto) {
		JobPosting jobPosting = modelMapper.map(jobPostingDto, JobPosting.class);
		jobPostingDao.save(jobPosting);
		System.out.println(jobPosting.getId());
		System.out.println(jobPosting.getMaxSalary());
		System.out.println(jobPosting.getNumberOfPosition());
		System.out.println(jobPosting.getMinSalary());
		return new SuccessResult("İş ilanı başarılı bir şekilde eklendi.");
	}


	@Override
	public Result activeJobPosting(int id) {
		JobPosting job = jobPostingDao.getById(id);
		if(job.getStatus()==true) {
			return new ErrorResult("İlan zaten aktif durumda!!!");
		}
		System.out.println(job.getId());
		System.out.println(job.getStatus());
		job.setStatus(true);
		this.jobPostingDao.save(job);		
		return new SuccessResult("İş ilanı başarılı bir şekilde aktif hale getirilmiştir.");
	}

		

}
