package com.proje.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.proje.model.Advertisement;
import com.proje.model.Education;
import com.proje.model.User;
import com.proje.model.UserInfo;
import com.proje.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private EntityManager entityManager = entityFactory.getEntityManager();

	EntityTransaction transaction = this.entityManager.getTransaction();

	public boolean saveUser(User user) {
		try {

			this.transaction.begin();

			this.entityManager.persist(user);

			this.transaction.commit();

		} catch (RollbackException e) {
			System.out.println("HATA  :  " + e);

			try {

			} catch (RollbackException e2) {
				System.out.println("HATA  :  " + e2);
			}
		}
		return true;
	}

	public boolean updateUser(User user) {
		try {

			this.transaction.begin();

			this.entityManager.persist(user);

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

	public boolean removeUser(User user) {
		try {

			if (this.entityManager.contains(user)) {
				this.entityManager.remove(user);
			} else {
				User deleteUser = this.findById(user.getUserId());

				this.entityManager.remove(deleteUser);
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

	public User findById(Integer id) {
		User education = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findById", User.class);
			typedQuery.setParameter("userId", id);

			education = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return education;
	}

	public User findByUsername(String username) {
		User education = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findByUsername", User.class);
			typedQuery.setParameter("username", username);

			education = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return education;
	}

	public User findWithUserDetailByUsername(String username) {
		User user = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findWithUserDetailByUsername",
					User.class);
			typedQuery.setParameter("username", username);

			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return user;
	}

	public List<User> findUsers() {
		List<User> user = null;
		try {

			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);

			user = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return user;
	}

	public List<User> findUsers(int firstResult, int maxResult) {
		List<User> users = null;
		try {

			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);

			users = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return users;
	}

	public int findUserCount() {
		int count = 0;

		try {

			Query typedQuery = this.entityManager.createNamedQuery("User.findById", User.class);

			count = (int) typedQuery.getFirstResult();
		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return count;
	}

	public UserInfo findUserInfoByUsername(String username) {
		UserInfo user = null;

		try {

			TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("User.findUserInfoByUsername",
					UserInfo.class);
			typedQuery.setParameter("username", username);

			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("HATA  :  " + e);
		}
		return user;
	}

}
