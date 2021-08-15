package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.FavoriteJobPosting;
import com.example.hrms.entities.dtos.FavoriteJobPostingAddDto;

public interface FavoriteJobPostingService {
	DataResult<List<FavoriteJobPosting>> getAll();
	
	Result add(FavoriteJobPosting favoriteJobPosting);
	
	Result addFavoriteJobPostingDto(FavoriteJobPostingAddDto favoriteJobPostingAddDto);
}
