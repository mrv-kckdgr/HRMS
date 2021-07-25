package com.example.hrms.business.concretes;

import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.business.abstracts.ResumeService;
import com.example.hrms.core.utilities.cloudinary.CloudinaryService;
import com.example.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EducationDao;
import com.example.hrms.dataAccess.abstracts.ResumeDao;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeManager implements ResumeService {
	private final ResumeDao resumeDao;
	private final CloudinaryService cloudinaryService;
	private final EducationDao educationDao;
	private final DtoConverterService dtoConverterService;


	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), "Listeleme başarılı");
	}

	@Override
	public Result add(Resume resume) {
		Resume r1 = resumeDao.save(resume);
		//this.resumeDao.save(resume);
		setResumeId(r1.getEducation(), r1);
		return new SuccessResult("Başarılı");
	}

	private void setResumeId(List<Education> education, Resume r1) {
		for(Education education2 : education) {
			education2.setResume(r1);
			educationDao.save(education2);
		}
		
	}

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>)
				cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		Resume cv = resumeDao.getOne(resumeId);
		cv.setImageUrl(imageUrl);
		resumeDao.save(cv);
		
		return new SuccessResult("Görsel başarılı bir şekilde eklendii");
	}

	@Override
	public DataResult<List<Resume>> getAllResume() {		
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), "Özgeçmiş görüntüleme başarılı");
	}

	@Override
	public DataResult<List<ResumeDto>> getResumeWithDetails() {		
		return new SuccessDataResult<List<ResumeDto>>(dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeDto.class), "Başarılı");
	}

	@Override
	public Result addResumeDto(ResumeDto resumeDto) {
		this.resumeDao.save((Resume) this.dtoConverterService.dtoClassConverter(resumeDto, Resume.class));
		return new SuccessResult("Özgeçmiş başarılı bir şekilde eklendi");
	}

	@Override
	public DataResult<List<ResumeDto>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<ResumeDto>>(this.resumeDao.getByCandidate_Id(candidateId), "Başarılı");
	}


	@Override
	public DataResult<ResumeDto> getByCandidateId(int candidateId) {		
		return new SuccessDataResult<ResumeDto>(resumeDao.getByCandidateId(candidateId), "success");
	}
}
