package com.proje.service.impl;

import java.util.List;

import com.proje.model.Advertisement;
import com.proje.repository.AdvertisementRepository;
import com.proje.repository.Impl.AdvertisementRepositoryImpl;
import com.proje.service.AdvertisementService;

public class AdvertisementServiceImpl implements AdvertisementService{

	AdvertisementRepository advertisementRepository = new AdvertisementRepositoryImpl();

	public boolean saveAdvertisement(Advertisement advertisement) {
		return this.advertisementRepository.saveAdvertisement(advertisement);
	}

	public boolean updateAdvertisement(Advertisement advertisement) {
		return this.advertisementRepository.updateAdvertisement(advertisement);
	}

	public boolean removeAdvertisement(Advertisement advertisement) {
		return this.advertisementRepository.removeAdvertisement(advertisement);
	}

	public Advertisement findById(Integer id) {
		return this.advertisementRepository.findById(id);
	}

	public List<Advertisement> findByUsername(String username) {
		return this.advertisementRepository.findByUsername(username);
	}

	public List<Advertisement> findAdvertisements() {
		return this.advertisementRepository.findAdvertisements();
	}

	public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {
		return this.advertisementRepository.findAdvertisementEntities(firstResult, maxResult);
	}
	
	
}
