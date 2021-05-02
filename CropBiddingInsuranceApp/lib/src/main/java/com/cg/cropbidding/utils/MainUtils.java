package com.cg.cropbidding.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.cropbidding.entities.Account;
import com.cg.cropbidding.entities.Address;
import com.cg.cropbidding.entities.Bank;
import com.cg.cropbidding.entities.Farmer;
import com.cg.cropbidding.exception.FarmerNotFoundException;
import com.cg.cropbidding.service.FarmerServiceImpl;
import com.cg.cropbidding.service.IFarmerService;

public class MainUtils {
	Logger logger = LogManager.getLogger(MainUtils.class);

	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String choice = null;
		IFarmerService farmerService = new FarmerServiceImpl();
		logger.info("Instantiated FarmerService instance");
		do {
			System.out.println("1. Add Farmer");
			System.out.println("2. Update Farmer");
			System.out.println("3. Retrieve Farmer");
			System.out.println("4. Retrieve All Farmers");
			System.out.println("5. Delete Farmer");
			System.out.println("Enter your choice: ");
			int selectedOption = sc.nextInt();
			logger.info(String.format("User Selected option %d", selectedOption));

			switch (selectedOption) {
			case 1:
				// Taking Farmer Details
				System.out.println("Enter Farmer name: ");
				String name = br.readLine();
				System.out.println("Enter Farmer contactNo: ");
				String contactNo = br.readLine();
				System.out.println("Enter Farmer EmailId: ");
				String emailId = br.readLine();
				System.out.println("Enter Farmer aadharNo: ");
				String aadharNo = br.readLine();
				System.out.println("Enter Farmer panNumber: ");
				String panNo = br.readLine();

				// Creating Farmer object
				Farmer farmer = new Farmer(name, contactNo, emailId, aadharNo, panNo);
				logger.info("Created farmer object with user input details");

				// Taking Home Address Details
				System.out.println("Home Address Details:");
				System.out.println("Enter houseNo: ");
				String houseNo = br.readLine();
				System.out.println("Enter street: ");
				String street = br.readLine();
				System.out.println("Enter city: ");
				String city = br.readLine();
				System.out.println("Enter state: ");
				String state = br.readLine();
				System.out.println("Enter pincode: ");
				String pincode = br.readLine();

				// Creating Home Address object
				Address homeAddress = new Address(houseNo, street, city, state, pincode);
				logger.info("Created Home address object with user input details");

				//// Taking Farm Address Details
				System.out.println("Farm Address Details:");
				System.out.println("Enter FarmNo: ");
				String houseNo1 = br.readLine();
				System.out.println("Enter street: ");
				String street1 = br.readLine();
				System.out.println("Enter city: ");
				String city1 = br.readLine();
				System.out.println("Enter state: ");
				String state1 = br.readLine();
				System.out.println("Enter pincode: ");
				String pincode1 = br.readLine();

				// Creating Farm Address object
				Address farmAddress = new Address(houseNo1, street1, city1, state1, pincode1);
				logger.info("Created Farm address object with user input details");

				// Taking Bank Address Details
				System.out.println("Bank Address Details:");
				System.out.println("Enter plotNo: ");
				String houseNo2 = br.readLine();
				System.out.println("Enter street: ");
				String street2 = br.readLine();
				System.out.println("Enter city: ");
				String city2 = br.readLine();
				System.out.println("Enter state: ");
				String state2 = br.readLine();
				System.out.println("Enter pincode: ");
				String pincode2 = br.readLine();

				// Creating Bank Address object
				Address bankAddress = new Address(houseNo2, street2, city2, state2, pincode2);
				logger.info("Created Bank address object with user input details");

				// Taking Bank Details
				System.out.println("Enter bankId: ");
				long bankId = sc.nextLong();
				System.out.println("Enter bankName: ");
				String bankName = br.readLine();
				System.out.println("Enter IFSCCode: ");
				String IFSCCode = br.readLine();

				// Creating Bank object
				//Bank bank = new Bank(bankId, bankName, IFSCCode);
				logger.info("Created bank object with user input details");

				// Taking Account Details
				System.out.println("Enter accountId: ");
				long accountId = sc.nextLong();

				// Creating Account object
				Account account = new Account(accountId);
				logger.info("Created account object with user input details");

				// Has-A relationship between Farmer, Address and Account
				farmer.setHomeAddress(homeAddress);
				farmer.setFarmAddress(farmAddress);
				farmer.setBankDetails(account);

				// Has-A relationship between Bank and Address
				//bank.setAddress(bankAddress);

				// Has-A relationship between Bank and Account
				//account.setBank(bank);

				// AddingFarmer
				Farmer f = farmerService.addFarmer(farmer);
				logger.info(String.format("Farmer %s saved successfully!", farmer.getName()));
				System.out.println(f.getName() + " is added successfully in the db");
				break;

			case 2:

				System.out.println("Enter Farmer userid: ");
				int userId1 = sc.nextInt();

					/*System.out.println("Enter Name:");
					String newName = br.readLine();
					System.out.println("Enter ContactNo:");
					String newContactNo = br.readLine();
					System.out.println("Enter EmailId:");
					String newEmailId = br.readLine();
					System.out.println("Enter AadharNo:");
					String newAadharNo = br.readLine();
					System.out.println("Enter PanNo:");
					String newPanNO = br.readLine();

					System.out.println("Enter HomeNo:");
					String newHomeNo = br.readLine();
					System.out.println("Enter Street:");
					String newStreet = br.readLine();
					System.out.println("Enter City:");
					String newCity = br.readLine();
					System.out.println("Enter State:");
					String newState = br.readLine();
					System.out.println("Enter Pincode:");
					String newPincode = br.readLine();
					
					System.out.println("Enter FarmNo:");
					String newHomeNo1 = br.readLine();
					System.out.println("Enter Street:");
					String newStreet1 = br.readLine();
					System.out.println("Enter City:");
					String newCity1 = br.readLine();
					System.out.println("Enter State:");
					String newState1 = br.readLine();
					System.out.println("Enter Pincode:");
					String newPincode1 = br.readLine();
					
					System.out.println("Enter BankNo:");
					String newHomeNo2 = br.readLine();
					System.out.println("Enter Street:");
					String newStreet2 = br.readLine();
					System.out.println("Enter City:");
					String newCity2 = br.readLine();
					System.out.println("Enter State:");
					String newState2 = br.readLine();
					System.out.println("Enter Pincode:");
					String newPincode2 = br.readLine();
					
					System.out.println("Enter BankId:");
					long newBankId = sc.nextLong();
					System.out.println("Enter BankName:");
					String newBankName = br.readLine();
					System.out.println("Enter IFSCCode:");
					String newIFSCCode = br.readLine();
					
					System.out.println("Enter AccountId:");
					long newAccountId = sc.nextLong();

					Farmer farmer1;
					try {
						farmer1 = farmerService.retrieveFarmerById(userId1);// Retrieve Farmer By UserId
						
						
						Address homeAddr=new Address(newHomeNo,newStreet,newCity, newState,newPincode );
						Address farmAddr=new Address(newHomeNo1,newStreet1,newCity1, newState1,newPincode1 );
						Address bankAddr=new Address(newHomeNo2,newStreet2,newCity2, newState2,newPincode2 );
						
						Bank b=new Bank(newBankId,newBankName,newIFSCCode);
						b.setAddress(bankAddr);
						Account acc=new Account(newAccountId);
						acc.setBank(b);
						
						farmer1.setName(newName);
						farmer1.setContactNumber(newContactNo);
						farmer1.setEmailId(newEmailId);
						farmer1.setAadharNumber(newAadharNo);
						farmer1.setPanNumber(newPanNO);
						farmer1.setHomeAddress(homeAddr);
						farmer1.setFarmAddress(farmAddr);
						farmer1.setBankDetails(acc);
					
						

						Farmer f1 = farmerService.updateFarmer(farmer1);// Update Farmer

						System.out.println("After update: ");

						System.out.println("UserId: " + f1.getUserId() + "\t\t Name: " + f1.getName()
								+ "\t\t ContactNo: " + f1.getContactNumber() + "\t\t EmailId: " + f1.getEmailId()
								+ "\t\t AadharNo: " + f1.getAadharNumber() + "\t\t PanNo: " + f1.getPanNumber()
								+ "\t\t HouseNo: " + f1.getHomeAddress().getHouseno() + "\t\t Street: "
								+ f1.getHomeAddress().getStreet() + "\t\t City: " + f1.getHomeAddress().getCity()
								+ "\t\t State: " + f1.getHomeAddress().getState() + "\t\t Pincode: "
								+ f1.getHomeAddress().getPincode());

						System.out.println(f1.getUserId() + " is updated successfully!");
						logger.debug("FarmerId: %d Farmer updated successfully!", f1.getUserId());

					} catch (FarmerNotFoundException fex1) {
						logger.error(fex1.getMessage());
						System.out.println(fex1.getMessage());
					}

					*/

				Farmer farmer1;
				try {
					farmer1 = farmerService.retrieveFarmerById(userId1);// Retrieve Farmer By UserId
					
					System.out.println("Before update: "+farmer1.getBankDetails().getBank().getBankId());
					
                     farmer1.getBankDetails().getBank().setBankId(104);// set value of bank id
					

					Farmer f1 = farmerService.updateFarmer(farmer1);// Update Farmer

					System.out.println("After update: "+f1.getBankDetails().getBank().getBankId());

					System.out.println(f1.getUserId() + " is updated successfully!");
					logger.debug("FarmerId: %d Farmer updated successfully!", f1.getUserId());

				} catch (FarmerNotFoundException fex1) {
					logger.error(fex1.getMessage());
					System.out.println(fex1.getMessage());
				}

				break;

			case 3:
				System.out.println("Enter Farmer userId:");
				int userId2 = sc.nextInt();
				Farmer farmer2;
				try {
					farmer2 = farmerService.retrieveFarmerById(userId2);// Retrieve Farmer By UserId
					System.out.println("UserId: " + farmer2.getUserId() + "\t\t Name: " + farmer2.getName()
							+ "\t\t ContactNo: " + farmer2.getContactNumber() + "\t\t EmailId: " + farmer2.getEmailId()
							+ "\t\t AadharNo: " + farmer2.getAadharNumber() + "\t\t PanNo: " + farmer2.getPanNumber()
							+ "\t\t HouseNo: " + farmer2.getHomeAddress().getHouseno() + "\t\t FarmNo: "
							+ farmer2.getFarmAddress().getHouseno() + "\t\t AccountId: "
							+ farmer2.getBankDetails().getAccountId());
				} catch (FarmerNotFoundException fex2) {
					logger.error(fex2.getMessage());
					System.out.println(fex2.getMessage());

				}

				break;

			case 4:
				List<Farmer> farmers = farmerService.retrieveAllFarmers();// Retrieve All Farmers
				for (Farmer fm : farmers) {
					System.out.println("UserId: " + fm.getUserId() + "\t\t Name: " + fm.getName() + "\t\t ContactNo: "
							+ fm.getContactNumber() + "\t\t EmailId: " + fm.getEmailId() + "\t\t AadharNo: "
							+ fm.getAadharNumber() + "\t\t PanNo: " + fm.getPanNumber() + "\t\t HouseNo: "
							+ fm.getHomeAddress().getHouseno() + "\t\t FarmNo: " + fm.getFarmAddress().getHouseno()
							+ "\t\t AccountId: " + fm.getBankDetails().getAccountId());
				}
				break;

			case 5:
				System.out.println("Enter farmer userId that needs to be deleted: ");
				int userId3 = sc.nextInt();
				Farmer farmer3 = farmerService.deleteFarmer(userId3);// Delete Farmer By UserId
				System.out.println(farmer3.getName() + " deleted successfully!");
				break;

			default:
				System.out.println("Please enter valid option!");
			}

			System.out.println("Do you want to continue? yes/no");
			choice = br.readLine();
			System.out.println(choice);
		} while (choice.equalsIgnoreCase("yes"));
		br.close();
		sc.close();
	}
}
