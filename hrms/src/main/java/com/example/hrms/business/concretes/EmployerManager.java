package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;
	
	public EmployerManager(EmployerDao employerDao, UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
	}
	@Override
	public DataResult<List<Employer>> getAll() {		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Veriler başarılı bir şekilde listelendi");
	}
	@Override
	public Result add(Employer employer) {
		if(userDao.existsByEmail(employer.getEmail())==false && employer.getPassword() == employer.getPasswordRepeat()) {
			this.employerDao.save(employer);
			return new SuccessResult("Çalışan başarılı bir şekilde eklendi");
		}
		return new ErrorResult("Çalışan eklenemedi, lütfen farklı bir mail adresi deneyiniz veya şifre alanlarınız uyuşmuyor olabilir!!!");
	}

}
