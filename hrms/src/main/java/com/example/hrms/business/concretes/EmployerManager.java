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
import com.example.hrms.entities.concretes.Employer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployerManager implements EmployerService {

	private final EmployerDao employerDao;
	
//	public EmployerManager(EmployerDao employerDao, UserDao userDao) {
//		super();
//		this.employerDao = employerDao;
//		this.userDao = userDao;
//	}
	
	@Override
	public DataResult<List<Employer>> getAll() {		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Veriler başarılı bir şekilde listelendi");
	}
	@Override
	public Result add(Employer employer) {
		//if(userDao.existsByEmail(employer.getEmail())==true && employer.getPassword() == employer.getPasswordRepeat()) {
			this.employerDao.save(employer);
			return new SuccessResult("Çalışan başarılı bir şekilde eklendi");
		//}
		//return new ErrorResult("Çalışan eklenemedi, lütfen farklı bir mail adresi deneyiniz veya şifre alanlarınız uyuşmuyor olabilir!!!");
	}
	@Override
	public Result loginEmployer(String email, String password) {
		System.out.println(email);
		System.out.println(password);
		if(email == "merve@merve.com" && password == "123456789") {
			return new SuccessResult("Giriş Başarılı");					
		}
		
	    return new ErrorResult("Giriş Başarısız!!!");			
		
	}

}
