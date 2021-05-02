package com.cg.cropbidding.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.cropbidding.entities.Address;
import com.cg.cropbidding.entities.Farmer;

public class FarmerRepositoryImpl implements IFarmerRepository {

	@Override
	public Farmer addFarmer(Farmer farmer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(farmer);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return farmer;

	}

	@Override
	public Farmer updateFarmer(Farmer farmer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Get farmer from db
		Farmer f = em.find(Farmer.class, farmer.getUserId());
		
		System.out.println("before:"+farmer.getBankDetails().getAccountId());
		
		f.getBankDetails().setAccountId(farmer.getBankDetails().getAccountId());
		
		System.out.println("after:"+f.getBankDetails().getAccountId());
        
		em.getTransaction().commit();
		emf.close();
		em.close();
		return f;
	}

	@Override
	public Farmer deleteFarmer(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Farmer farmer = em.find(Farmer.class, id);
		em.remove(farmer);
		em.getTransaction().commit();
		emf.close();
		em.close();
		return farmer;
	}

	@Override
	public List<Farmer> retrieveAllFarmers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Person");
		List<Farmer> farmers = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return farmers;
	}

	@Override
	public Farmer retrieveFarmerById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Farmer farmer = em.find(Farmer.class, id);
		em.getTransaction().commit();
		emf.close();
		em.close();
		return farmer;
	}

}
