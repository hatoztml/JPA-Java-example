package com.proje.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.Advertisement;
import com.proje.repository.AdvertisementRepository;

public class AdvertisementRepositoryImpl implements AdvertisementRepository {

	private EntityManager entityManager = entityFactory.getEntityManager();

	EntityTransaction transaction = this.entityManager.getTransaction();

	public boolean saveAdvertisement(Advertisement advertisement) {
		try {

			this.transaction.begin();

			this.entityManager.persist(advertisement);

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

	public boolean updateAdvertisement(Advertisement advertisement) {
		try {

			this.transaction.begin();

			this.entityManager.persist(advertisement);

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

	public boolean removeAdvertisement(Advertisement advertisement) {
		try {

			if (this.entityManager.contains(advertisement)) {
				this.entityManager.remove(advertisement);
			} else {
				Advertisement deleteAdvertisement = this.findById(advertisement.getAdvertisementId());

				this.entityManager.remove(deleteAdvertisement);
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

	public Advertisement findById(Integer id) {
		Advertisement advertisement = null;

		try {

			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertismen.findById",
					Advertisement.class);
			typedQuery.setParameter("advertisementId", id);

			advertisement = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return advertisement;
	}

	public List<Advertisement> findByUsername(String username) {
		List<Advertisement> advertisements = null;
		try {

			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertismen.findByUsername",
					Advertisement.class);
			typedQuery.setParameter("username", username);

			advertisements = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return advertisements;
	}

	public List<Advertisement> findAdvertisements() {
		List<Advertisement> advertisements = null;
		try {

			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertismen.findAdvertisements",
					Advertisement.class);

			advertisements = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return advertisements;
	}

	public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {
		List<Advertisement> advertisements = null;
		try {

			TypedQuery<Advertisement> typedQuery = this.entityManager
					.createNamedQuery("Advertismen.findAdvertisementEntities", Advertisement.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);

			advertisements = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return advertisements;
	}
}
