package com.example.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobExperienceDao;
import com.example.hrms.entities.concretes.JobExperience;
import com.example.hrms.entities.dtos.JobExperienceAddDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobExperienceManager implements JobExperienceService {
	
	private final JobExperienceDao jobExperienceDao;
	private final ModelMapper modelMapper;


	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.findAll(), "İş deneyimleri başarılı bir şekilde listelendi");
	}

	@Override
	public Result add(JobExperience jobExperience) {
		jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş deneyimi başarılı bir şekilde eklendi");
	}

	@Override
	public DataResult<List<JobExperience>> getAllSortedDesc() {
		// In descending order by endDate
		Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(sort), "Tarihe göre listeleme işlemi başarılı.");
	}

	@Override
	public Result addJobExperienceDto(JobExperienceAddDto jobExperienceAddDto) {
		JobExperience jobExperience = modelMapper.map(jobExperienceAddDto, JobExperience.class);
		jobExperienceDao.save(jobExperience);
		System.out.println(jobExperience.getId());
		System.out.println(jobExperience.getCompanyName());
		return new SuccessResult("İş deneyimi başarılı bir şekilde eklendi.");
	}

	@Override
	public Result updateJobExperienceDto(JobExperienceAddDto jobExperienceAddDto) {
		JobExperience jobExperienceUpdate = this.jobExperienceDao.getById(jobExperienceAddDto.getId());
		jobExperienceUpdate.setCompanyName(jobExperienceAddDto.getCompanyName());
		jobExperienceUpdate.setCreateDate(LocalDate.now());
		jobExperienceUpdate.setEndDate(jobExperienceAddDto.getEndDate());
		//jobExperienceUpdate.setJobPosition(jobExperienceAddDto.getJobPositionId());
		//jobExperienceUpdate.setResume(jobExperienceAddDto.getResumeId());
		jobExperienceUpdate.setStartingDate(jobExperienceAddDto.getStartingDate());
		this.jobExperienceDao.save(jobExperienceUpdate);
		return new SuccessResult("İş deneyimi başarılı bir şekilde güncellendi.");
	}

	@Override
	public DataResult<JobExperience> getById(int id) {
		return new SuccessDataResult<JobExperience>(this.jobExperienceDao.getById(id),"Listeleme başarılı");
	}

	@Override
	public DataResult<List<JobExperience>> getByResume_Id(int resumeId) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getByResume_Id(resumeId), "Listeleme başarılı");
	}

}
