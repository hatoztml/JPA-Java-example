package com.proje.service.impl;

import com.proje.model.UserDetail;
import com.proje.repository.UserDetailRepository;
import com.proje.repository.Impl.UserDetailRepositoryImpl;
import com.proje.service.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService {

	UserDetailRepository userDetailRepository = new UserDetailRepositoryImpl();

	public boolean saveUserDetail(UserDetail userDetail) {
		return this.userDetailRepository.saveUserDetail(userDetail);
	}

	public boolean updateUserDetail(UserDetail userDetail) {
		return this.userDetailRepository.updateUserDetail(userDetail);
	}

	public boolean removeUserDetail(UserDetail userDetail) {
		return this.userDetailRepository.removeUserDetail(userDetail);
	}

	public UserDetail findById(Integer id) {
		return this.userDetailRepository.findById(id);
	}

	public UserDetail findByUsername(String username) {
		return this.userDetailRepository.findByUsername(username);
	}

	public UserDetail findWithAddressByUsername(String username) {
		return this.userDetailRepository.findWithAddressByUsername(username);
	}

	public UserDetail findWithAdvertisementByUsername(String username) {
		return this.userDetailRepository.findWithAdvertisementByUsername(username);
	}
	
	
}
