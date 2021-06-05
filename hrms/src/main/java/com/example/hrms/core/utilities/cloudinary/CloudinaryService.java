package com.example.hrms.core.utilities.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<?> save(MultipartFile file);
}
