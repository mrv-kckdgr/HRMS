package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.WorkingTimeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.WorkingTimeDao;
import com.example.hrms.entities.concretes.WorkingTime;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkingTimeManager implements WorkingTimeService {

	private final WorkingTimeDao workingTimeDao;

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll(), "Listeleme başarılı");
	}
}
