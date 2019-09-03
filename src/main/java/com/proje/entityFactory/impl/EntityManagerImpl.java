package com.proje.entityFactory.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.proje.entityFactory.EntityFactory;

public class EntityManagerImpl implements EntityFactory {

	public EntityManager getEntityManager() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
		
		return entityManagerFactory.createEntityManager();
	}


}
