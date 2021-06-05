package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EducationDao;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {		
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "Eğitim başarılı bir şekilde listelendi");
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Eğitim başarılı bir şekilde eklendi.");
	}

	@Override
	public Result add(EducationDto educationDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Education>> getAllSortedDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(sort), "Success");
	}
}
