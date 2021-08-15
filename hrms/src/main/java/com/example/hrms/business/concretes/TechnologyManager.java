package com.example.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.TechnologyService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.TechnologyDao;
import com.example.hrms.entities.concretes.Technology;
import com.example.hrms.entities.dtos.TechnologyAddDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechnologyManager implements TechnologyService {
	private final TechnologyDao technologyDao;
	private final ModelMapper modelMapper;

	@Override
	public DataResult<List<Technology>> getAll() {		
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), "Teknolojiler başarılı bir şekilde eklendi.");
	}

	@Override
	public Result add(Technology technology) {
		this.technologyDao.save(technology);
		return new SuccessResult("Teknoloji başarılı bir şekilde eklendi.");
	}

	@Override
	public Result addTechnologyDto(TechnologyAddDto technologyAddDto) {
		Technology technology = modelMapper.map(technologyAddDto, Technology.class);
		technologyDao.save(technology);
		System.out.println(technology.getId());
		System.out.println(technology.getDescription());		
		return new SuccessResult("Teknoloji başarılı bir şekilde eklendi.");
	}

	@Override
	public DataResult<List<Technology>> getByResume_Id(int resumeId) {
		return new SuccessDataResult<List<Technology>>(technologyDao.getByResume_Id(resumeId), "Listeleme başarılı");
	}

	@Override
	public DataResult<Technology> getById(int id) {
		return new SuccessDataResult<Technology>(technologyDao.getById(id), "Listeleme başarılı");
	}

	@Override
	public Result updateTechnologyDto(TechnologyAddDto technologyAddDto) {
		Technology updatedTechnology = modelMapper.map(technologyAddDto, Technology.class);
		updatedTechnology.setDescription(technologyAddDto.getDescription());
		technologyDao.save(updatedTechnology);
		return new SuccessResult("Güncelleme işlemi başarılı bir şekilde gerçekleştirildi.");
	}
}
