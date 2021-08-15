package com.example.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.FavoriteJobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.FavoriteJobPostingDao;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.FavoriteJobPosting;
import com.example.hrms.entities.dtos.FavoriteJobPostingAddDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoriteJobPostingManager implements FavoriteJobPostingService {
	
	private final FavoriteJobPostingDao favoriteJobPostingDao;
	private final ModelMapper modelMapper;

	@Override
	public DataResult<List<FavoriteJobPosting>> getAll() {
		return new SuccessDataResult<List<FavoriteJobPosting>>(favoriteJobPostingDao.findAll(), "Listeleme başarılı");
	}

	@Override
	public Result add(FavoriteJobPosting favoriteJobPosting) {
		favoriteJobPostingDao.save(favoriteJobPosting);
		return new SuccessResult("İş ilanı başarılı bir şekilde eklendi.");
	}

	@Override
	public Result addFavoriteJobPostingDto(FavoriteJobPostingAddDto favoriteJobPostingAddDto) {
		FavoriteJobPosting favoriteJobPosting = modelMapper.map(favoriteJobPostingAddDto, FavoriteJobPosting.class);
		favoriteJobPostingDao.save(favoriteJobPosting);
		System.out.println(favoriteJobPosting.getId());
		System.out.println(favoriteJobPosting.getCandidate());
		return new SuccessResult("Favori iş ilanı başarılı bir şekilde eklendi.");
	}

}
