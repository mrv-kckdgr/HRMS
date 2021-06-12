package com.example.hrms.core.utilities.dtoConverter;

import java.util.List;

public interface DtoConverterService {
	// s-> DTO, targetClass-> class
	<S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass);
	
	public <T> Object dtoClassConverter(Object source, Class<T> baseClass);
}
//List<T> dto döndür
