package com.example.hrms.business.concretes;

import java.util.List;


import org.springframework.stereotype.Service;


import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LanguageDao;
import com.example.hrms.entities.concretes.Language;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageManager implements LanguageService{
	private final LanguageDao languageDao;

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Diller başarılı bir şekilde listelendi.");
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Dil başarılı bir şekilde eklendi.");
	}
}
