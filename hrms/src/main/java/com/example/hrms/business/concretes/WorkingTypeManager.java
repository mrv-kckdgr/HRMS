package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.WorkingTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.WorkingTypeDao;
import com.example.hrms.entities.concretes.WorkingType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkingTypeManager implements WorkingTypeService {

	private final WorkingTypeDao workingTypeDao;
	
	@Override
	public DataResult<List<WorkingType>> getAll() {		
		return new SuccessDataResult<List<WorkingType>>(workingTypeDao.findAll(), "Listeleme başarılı");
	}

}
