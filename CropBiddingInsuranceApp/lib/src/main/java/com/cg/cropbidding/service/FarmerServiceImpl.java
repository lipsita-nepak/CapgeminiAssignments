package com.cg.cropbidding.service;

import java.util.List;

import com.cg.cropbidding.entities.Farmer;
import com.cg.cropbidding.exception.FarmerNotFoundException;
import com.cg.cropbidding.repository.FarmerRepositoryImpl;
import com.cg.cropbidding.repository.IFarmerRepository;

public class FarmerServiceImpl implements IFarmerService{

	IFarmerRepository farmerRepository= new FarmerRepositoryImpl();
	
	@Override
	public Farmer addFarmer(Farmer farmer) {
		
		return farmerRepository.addFarmer(farmer);
	}

	@Override
	public Farmer updateFarmer(Farmer farmer) {
		return farmerRepository.updateFarmer(farmer);
	}

	@Override
	public Farmer deleteFarmer(int id) {
		
	 return farmerRepository.deleteFarmer(id);
	}

	@Override
	public List<Farmer> retrieveAllFarmers() {
		return farmerRepository.retrieveAllFarmers();
	}

	@Override
	public Farmer retrieveFarmerById(int id)throws FarmerNotFoundException{
		if(farmerRepository.retrieveFarmerById(id) == null) {
			throw new FarmerNotFoundException("Farmer not found with id: "+id);
		}
		return farmerRepository.retrieveFarmerById(id);
	}

}
