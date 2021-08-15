package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.dtos.LanguageAddDto;
//import com.example.hrms.entities.dtos.LanguageDto;
import com.example.hrms.entities.dtos.TechnologyAddDto;

public interface LanguageService {
	DataResult<List<Language>> getAll();
	
	Result add(Language language);
	
	Result addLanguageDto(LanguageAddDto languageAddDto);
	
	DataResult<List<Language>> getByResume_Id(int resumeId);
	
	Result updateLanguageDto(LanguageAddDto languageAddDto);
	
	DataResult<Language> getById(int id);
}
