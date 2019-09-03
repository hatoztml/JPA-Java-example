package com.proje.service.impl;

import java.util.List;

import com.proje.model.Education;
import com.proje.repository.EducationRepository;
import com.proje.repository.Impl.EducationRepositoryImpl;
import com.proje.service.EducationService;

public class EducationServiceImpl implements EducationService{

	EducationRepository educationRepository = new EducationRepositoryImpl();

	public boolean saveEducation(Education education) {
		return this.educationRepository.saveEducation(education);
	}

	public boolean updateEducation(Education education) {
		return this.educationRepository.updateEducation(education);
	}

	public boolean removeEducation(Education education) {
		return this.educationRepository.removeEducation(education);
	}

	public Education findById(Integer educationId) {
		return this.educationRepository.findById(educationId);
	}

	public List<Education> educations() {
		return this.educationRepository.educations();
	}

	public Education findWithAdvertisementById(Integer educationtId) {
		return this.educationRepository.findWithAdvertisementById(educationtId);
	}
}
