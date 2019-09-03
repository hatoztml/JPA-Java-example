package com.proje.service;

import java.util.List;

import com.proje.model.Education;

public interface EducationService {

	boolean saveEducation(Education education);

	boolean updateEducation(Education education);

	boolean removeEducation(Education education);

	Education findById(Integer educationId);

	List<Education> educations();

	Education findWithAdvertisementById(Integer educationtId);
}
