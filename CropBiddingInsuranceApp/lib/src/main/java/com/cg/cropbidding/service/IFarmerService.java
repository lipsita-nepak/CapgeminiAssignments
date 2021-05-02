package com.cg.cropbidding.service;

import java.util.List;

import com.cg.cropbidding.entities.Farmer;
import com.cg.cropbidding.exception.FarmerNotFoundException;

public interface IFarmerService {
		
		public Farmer addFarmer(Farmer farmer);
		public Farmer updateFarmer(Farmer farmer);
		public Farmer deleteFarmer(int id);
		public List<Farmer> retrieveAllFarmers();
		public Farmer retrieveFarmerById(int id) throws FarmerNotFoundException;
		

	

}
