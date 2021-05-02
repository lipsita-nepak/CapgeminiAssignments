package com.cg.cropbidding.repository;

import java.util.List;

import com.cg.cropbidding.entities.Farmer;

public interface IFarmerRepository {

	public Farmer addFarmer(Farmer farmer);
	public Farmer updateFarmer(Farmer farmer);
	public Farmer deleteFarmer(int id);
	public List<Farmer> retrieveAllFarmers();
	public Farmer retrieveFarmerById(int id);
	
}
