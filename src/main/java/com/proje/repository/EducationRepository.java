package com.proje.repository;

import java.util.List;

import com.proje.entityFactory.EntityFactory;
import com.proje.entityFactory.impl.EntityManagerImpl;
import com.proje.model.Education;

public interface EducationRepository {

	EntityFactory entityFactory = new EntityManagerImpl();

	boolean saveEducation(Education education);

	boolean updateEducation(Education education);

	boolean removeEducation(Education education);

	Education findById(Integer educationId);

	List<Education> educations();

	Education findWithAdvertisementById(Integer educationtId);

}
