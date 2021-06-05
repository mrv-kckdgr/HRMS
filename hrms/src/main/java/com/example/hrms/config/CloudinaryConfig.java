package com.example.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.core.utilities.cloudinary.CloudinaryManager;
import com.example.hrms.core.utilities.cloudinary.CloudinaryService;

import org.springframework.beans.factory.annotation.Value;


@Configuration
public class CloudinaryConfig {
	@Value("${cld.access-key}")
	String apiKey;
	
	@Value("${cld.secret-key}")
	String apiSecretKey;
	
	@Bean
	public Cloudinary cloudinaryUser() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "mervekdjava",
				"api_key", apiKey,
				"api_secret", apiSecretKey));
	}
	
	@Bean
	public CloudinaryService cloudinaryService() {
		return new CloudinaryManager(cloudinaryUser());
	}
}
