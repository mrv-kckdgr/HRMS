package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.GraduateTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.GraduateTypeDao;
import com.example.hrms.entities.concretes.GraduateType;

@Service
public class GraduateTypeManager implements GraduateTypeService {
	private GraduateTypeDao graduateDao;

	@Autowired
	public GraduateTypeManager(GraduateTypeDao graduateDao) {
		super();
		this.graduateDao = graduateDao;
	}

	@Override
	public DataResult<List<GraduateType>> getAll() {		
		return new SuccessDataResult<List<GraduateType>>(graduateDao.findAll(), "Listeleme başarılı");
	}

	@Override
	public Result add(GraduateType graduateType) {
		if(graduateDao.existsByDescription(graduateType.getDescription())) {
			return new ErrorResult("Aynı kayıt ikinci kez eklenemez!");
		}
		this.graduateDao.save(graduateType);
		return new SuccessResult("Ekleme başarılı");
	}
}
