package com.proje.repository.Impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.Education;
import com.proje.model.UserDetail;
import com.proje.repository.UserDetailRepository;

public class UserDetailRepositoryImpl implements UserDetailRepository {

	private EntityManager entityManager = entityFactory.getEntityManager();

	EntityTransaction transaction = this.entityManager.getTransaction();

	public boolean saveUserDetail(UserDetail userDetail) {
		try {

			this.transaction.begin();

			this.entityManager.persist(userDetail);

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

	public boolean updateUserDetail(UserDetail userDetail) {
		try {

			this.transaction.begin();

			this.entityManager.persist(userDetail);

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

	public boolean removeUserDetail(UserDetail userDetail) {
		try {

			if (this.entityManager.contains(userDetail)) {
				this.entityManager.remove(userDetail);
			} else {
				UserDetail deleteUserDetail = this.findById(userDetail.getUserDetailId());

				this.entityManager.remove(deleteUserDetail);
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

	public UserDetail findById(Integer id) {
		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findById",
					UserDetail.class);
			typedQuery.setParameter("userDetailId", id);

			userDetail = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return userDetail;
	}

	public UserDetail findByUsername(String username) {
		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findByUsername",
					UserDetail.class);
			typedQuery.setParameter("username", username);

			userDetail = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return userDetail;
	}

	public UserDetail findWithAddressByUsername(String username) {
		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithAddressByUsername",
					UserDetail.class);
			typedQuery.setParameter("username", username);

			userDetail = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return userDetail;
	}

	public UserDetail findWithAdvertisementByUsername(String username) {
		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithAdvertisementByUsername",
					UserDetail.class);
			typedQuery.setParameter("username", username);

			userDetail = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return userDetail;
	}

}
