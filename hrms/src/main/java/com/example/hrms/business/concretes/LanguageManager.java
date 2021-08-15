package com.example.hrms.business.concretes;


import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LanguageDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.dtos.LanguageAddDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageManager implements LanguageService{
	private final LanguageDao languageDao;
	private final ModelMapper modelMapper;

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Diller başarılı bir şekilde listelendi.");
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Dil başarılı bir şekilde eklendi.");
	}

	@Override
	public Result addLanguageDto(LanguageAddDto languageAddDto) {
		Language language = modelMapper.map(languageAddDto, Language.class);	
		languageDao.save(language);
		System.out.println(language.getLanguageName());		
		return new SuccessResult("Dil başarılı bir şekilde eklendi.");
	}

	@Override
	public DataResult<List<Language>> getByResume_Id(int resumeId) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getByResume_Id(resumeId), "Veriler başarılı bir şekilde listelendi.");		
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(languageDao.getById(id), "Listeleme başarılı");
	}
	
	
	@Override
	public Result updateLanguageDto(LanguageAddDto languageAddDto) {
		System.out.println(languageAddDto.getLanguageName());
		Language updateLanguage = modelMapper.map(languageAddDto, Language.class);
		updateLanguage.setCreateDate(LocalDate.now());
		updateLanguage.setLanguageName(languageAddDto.getLanguageName());
		updateLanguage.setLanguageLevel(languageAddDto.getLanguageLevel());		
		languageDao.save(updateLanguage);
		System.out.println(updateLanguage.getLanguageName());		
		return new SuccessResult("Dil başarılı bir şekilde güncellendi.");
	}

	
}
