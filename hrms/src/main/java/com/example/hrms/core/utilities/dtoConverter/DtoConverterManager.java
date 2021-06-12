package com.example.hrms.core.utilities.dtoConverter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DtoConverterManager implements DtoConverterService {

	private ModelMapper modelMapper;
	
	@Autowired
	public DtoConverterManager(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	//List<S> kaynak sınıfın kendisi
	public <S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass) {		
		return s.stream().map(element->modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}

	@Override
	public <T> Object dtoClassConverter(Object source, Class<T> baseClass) {		
		return modelMapper.map(source, baseClass);
	}

}
