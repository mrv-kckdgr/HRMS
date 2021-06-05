package com.example.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.business.abstracts.ResumeService;
import com.example.hrms.core.utilities.cloudinary.CloudinaryService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EducationDao;
import com.example.hrms.dataAccess.abstracts.ResumeDao;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {
	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	private EducationDao educationDao;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService, EducationDao educationDao) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;
		this.educationDao=educationDao;
	}

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
		
		Map<String, String> uploader = (Map<String, String>)
				cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		Resume cv = resumeDao.getOne(resumeId);
		cv.setImageUrl(imageUrl);
		resumeDao.save(cv);
		
		return new SuccessResult("Görsel başarılı bir şekilde eklendii");
	}
}
