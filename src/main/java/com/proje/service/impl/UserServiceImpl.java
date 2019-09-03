package com.proje.service.impl;

import java.util.List;

import com.proje.model.User;
import com.proje.model.UserInfo;
import com.proje.repository.UserRepository;
import com.proje.repository.Impl.UserRepositoryImpl;
import com.proje.service.UserService;

public class UserServiceImpl implements UserService{

	UserRepository userRepository = new UserRepositoryImpl();

	public boolean saveUser(User user) {
		return this.userRepository.saveUser(user);
	}

	public boolean updateUser(User user) {
		return this.userRepository.updateUser(user);
	}

	public boolean removeUser(User user) {
		return this.userRepository.removeUser(user);
	}

	public User findById(Integer id) {
		return this.userRepository.findById(id);
	}

	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	public User findWithUserDetailByUsername(String username) {
		return this.userRepository.findWithUserDetailByUsername(username);
	}

	public List<User> findUsers() {
		return this.userRepository.findUsers();
	}

	public List<User> findUsers(int firstResult, int maxResult) {
		return this.userRepository.findUsers();
	}

	public int findUserCount() {
		return this.userRepository.findUserCount();
	}

	public UserInfo findUserInfoByUsername(String username) {
		return this.userRepository.findUserInfoByUsername(username);
	}
	
	
}
