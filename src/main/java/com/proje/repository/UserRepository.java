package com.proje.repository;

import java.util.List;

import com.proje.entityFactory.EntityFactory;
import com.proje.entityFactory.impl.EntityManagerImpl;
import com.proje.model.User;
import com.proje.model.UserInfo;

public interface UserRepository {

	EntityFactory entityFactory = new EntityManagerImpl();

	boolean saveUser(User user);
	
	boolean updateUser(User user);
	
	boolean removeUser(User user);
	
	User findById(Integer id);
	
	User findByUsername(String username);
	
	User findWithUserDetailByUsername(String username);
	
	List<User> findUsers();
	
	List<User> findUsers(int firstResult, int maxResult);
	
	int findUserCount();
	
	UserInfo findUserInfoByUsername(String username);
}
