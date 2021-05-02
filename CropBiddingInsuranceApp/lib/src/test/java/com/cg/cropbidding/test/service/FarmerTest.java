package com.cg.cropbidding.test.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.cg.cropbidding.entities.Account;
import com.cg.cropbidding.entities.Address;
import com.cg.cropbidding.entities.Bank;
import com.cg.cropbidding.entities.Farmer;
import com.cg.cropbidding.exception.FarmerNotFoundException;
import com.cg.cropbidding.service.FarmerServiceImpl;
import com.cg.cropbidding.service.IFarmerService;

class FarmerTest {

	IFarmerService farmerService;
	
    @BeforeEach
	void setUp() throws Exception {
    	farmerService=new FarmerServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		farmerService=null;
	}

	@Test
	@Disabled
	void testShouldAddFarmer() {
		Address homeAddress=new Address("101A","Behera Street","Bhubaneswar","Odisha","760005");
		Address farmAddress=new Address("201B","Nandan Kanan Road","Bhubaneswar","Odisha","760004");
		Address bankAddress=new Address("301C","Chandrasekharpur","Bhubaneswar","Odisha","760003");
		
		Bank bank=new Bank("State Bank","SSRT123");
		bank.setAddress(bankAddress);

		Account account=new Account(1673211);
		account.setBank(bank);
		
		Farmer farmer=new Farmer("Sneha","9861778566","sneha@gmail.com","1459 8900 7863","UTHC01259");
		
		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
				
		
		Farmer persistedFarmer = farmerService.addFarmer(farmer);
		System.out.println(persistedFarmer);
		
		assertAll(
		() -> assertEquals("Sneha", persistedFarmer.getName()),
		() -> assertEquals("9861778566", persistedFarmer.getContactNumber()),
		() -> assertEquals("sneha@gmail.com", persistedFarmer.getEmailId()),
		() ->assertEquals("1459 8900 7863", persistedFarmer.getAadharNumber()),
		() ->assertEquals("UTHC01259",persistedFarmer.getPanNumber()),
		() ->assertEquals(1673211,persistedFarmer.getBankDetails().getAccountId()));
		
	}
	
	@Test
	@Disabled
	void testShouldDeleteFarmerById() {
		Farmer farmer = farmerService.deleteFarmer(8);
		assertEquals(8, farmer.getUserId());
	}
	
	@Test
	@Disabled
	@Order(2)
	void testShouldGetAllFarmer() {
		List<Farmer> farmers = farmerService.retrieveAllFarmers();
		assertEquals(3, farmers.size());
	}
	
	@Test
	//@Disabled
	@Order(1)
	void testShouldUpdateFarmer() {
		Farmer farmer = new Farmer();
		//Address homeAddress=new Address("102C","NAYAPALLI","Bhubaneswar","Odisha","760005");
		
		farmer.setUserId(29);
	   // farmer.setName("Sneha");
	   // farmer.setAadharNumber("1459 8900 7863");
	   // farmer.setContactNumber("9861778566");
	   // farmer.setEmailId("sneha123@gmail.com");
	   // farmer.setPanNumber("UTHC01259");
	    //farmer.setHomeAddress(homeAddress);
		//farmer.getHomeAddress().setStreet("ppp");
		
		farmer.getBankDetails().setAccountId(30112);
		Farmer updatedFarmer= farmerService.updateFarmer(farmer);
		System.out.println(updatedFarmer);
		assertAll(
			() ->assertEquals("UTHC01259", updatedFarmer.getPanNumber()),
			() ->assertEquals("Behera Street",updatedFarmer.getHomeAddress().getStreet())
			);
		
	}
	
	@Test
	@Disabled
	void testShouldGetFarmerById() throws FarmerNotFoundException {
		Farmer farmer = farmerService.retrieveFarmerById(13);
		assertEquals("Sneha",farmer.getName());
	}

}
