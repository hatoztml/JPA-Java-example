package com.proje.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.Advertisement;
import com.proje.model.Education;
import com.proje.repository.EducationRepository;

public class EducationRepositoryImpl implements EducationRepository {

	private EntityManager entityManager = entityFactory.getEntityManager();

	EntityTransaction transaction = this.entityManager.getTransaction();

	public boolean saveEducation(Education education) {
		try {

			this.transaction.begin();

			this.entityManager.persist(education);

			this.transaction.commit();

		} catch (RuntimeException e) {
			System.out.println("HATA  :  " + e);

			try {

			} catch (RollbackException e2) {
				System.out.println("HATA  :  " + e2);
			}
		}
		return true;
	}

	public boolean updateEducation(Education education) {
		try {

			this.transaction.begin();

			this.entityManager.persist(education);

			this.transaction.commit();

		} catch (RuntimeException e) {
			System.out.println("HATA  :  " + e);

			try {

			} catch (RollbackException e2) {
				System.out.println("HATA  :  " + e2);
			}
		}
		return true;
	}

	public boolean removeEducation(Education education) {
		try {

			if (this.entityManager.contains(education)) {
				this.entityManager.remove(education);
			} else {
				Education deleteEducation = this.findById(education.getEducationId());

				this.entityManager.remove(deleteEducation);
			}

		} catch (RuntimeException e) {
			System.out.println("HATA  :  " + e);

			try {

			} catch (RollbackException e2) {
				System.out.println("HATA  :  " + e2);
			}
			return false;
		}
		return true;
	}

	public Education findById(Integer educationId) {
		Education education = null;

		try {

			TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findById",
					Education.class);
			typedQuery.setParameter("educationId", educationId);

			education = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return education;
	}

	public List<Education> educations() {
		List<Education> educations = null;

		try {

			TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findEducations",
					Education.class);
			educations = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("HATAT  :" + e);
		}
		return educations;
	}

	public Education findWithAdvertisementById(Integer educationtId) {
		Education education=null;
		
		try {
			TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findWithAdvertisementById", Education.class);
			typedQuery.setParameter("educationtId", educationtId);
			
			education = typedQuery.getSingleResult();
			
			
		} catch (NoResultException e) {
			System.out.println("HATAT  :" + e);
		}
		return education;
	}

}
