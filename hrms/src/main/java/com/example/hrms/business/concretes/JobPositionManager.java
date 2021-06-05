package com.example.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobPositionService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPositionDao;
import com.example.hrms.entities.concretes.JobPosition;


import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	//private ModelMapper modelMapper;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, ModelMapper modelMapper) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	
	
	@Override
	public Result add(JobPosition jobPosition) {
		if(jobPositionDao.existsByPosition(jobPosition.getPosition())==false) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Pozisyon başarılı bir şekilde eklendi.");
		}
		return new ErrorResult("Pozisyon eklenemedi, lütfen farklı bir pozisyon ismi deneyiniz!!!");
		
	}



	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}
	
	
}