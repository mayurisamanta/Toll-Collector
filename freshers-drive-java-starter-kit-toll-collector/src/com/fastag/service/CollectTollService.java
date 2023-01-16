package com.fastag.service;

import java.util.Set;

import com.fastag.constants.DefaultInitializer;
import com.fastag.constants.TollCharges;
import com.fastag.dto.TollCollectionSummary;
import com.fastag.dto.VehicleSummary;
import com.fastag.entity.Fastag;
import com.fastag.entity.Vehicle;

public class CollectTollService {

	//Vehicle will to added by creating vehicle entity and this will be added to Toll collection summary
	public void addVehicle(String vehicle_type, String vehicle_number, TollCollectionSummary tollCollectionSummary) {
		
		//Creating vehicle entity
		Set<Vehicle> vehicles = tollCollectionSummary.getVehicles();
		
		//initializing variables with default values
		Vehicle currentVehicle = null;
		
		Boolean returnJourney = DefaultInitializer.BOOLEAN_INITIALIZER;
		
		Boolean existingVehicle = DefaultInitializer.BOOLEAN_INITIALIZER;
		
		//searching for vehicle if already available
		for (Vehicle v : vehicles) {
			if (v.getVehicle_number().equals(vehicle_number)) {
				
				//Increasing the journey count by 1
				v.setJourneys(v.getJourneys() + 1);
				
				//checking if it is return journey or not
				//if return journey then changing the value of returnJourney to true
				if (v.getJourneys() % 2 == 0) returnJourney = true;
				
				//changing the existingVehicle value to true
				existingVehicle = true;
				
				//assigning the vehicle entity reference to currentVehicle
				currentVehicle = v;
				
				break;
			}
		}
		
		//if vehicle does not exist then creating new vehicle and assigning it to currentVehicle variable
		if (existingVehicle == false) {
			Vehicle vehicle = new Vehicle(vehicle_type, vehicle_number, 1);
			tollCollectionSummary.getVehicles().add(vehicle);
			currentVehicle = vehicle;
		}
		
		//calling collectToll method by passing required parameters
		collectToll(currentVehicle, returnJourney, tollCollectionSummary);
	}
	
	//Toll charges will be deducted if fastag amount is available, if not available cash will be deducted
	//And if return journey then discount will be given
	public void collectToll(Vehicle currentVehicle, Boolean returnJourney, TollCollectionSummary tollCollectionSummary) {
		
		//Initializing all the variables with default value
		Fastag currentVehicleFastag = null;
		
		Integer total_amount_collected_via_fastag = DefaultInitializer.INTEGER_INITIALIZER; 
		
		Integer total_amount_collected_via_cash = DefaultInitializer.INTEGER_INITIALIZER; 
		
		Integer flat_fee_for_cash_payment = DefaultInitializer.INTEGER_INITIALIZER;
		
		Integer discount = DefaultInitializer.INTEGER_INITIALIZER;
		
		//getting all fastags available in tollCollectionSummary
		Set<Fastag> fastags = tollCollectionSummary.getFastags();
		
		//getting toll charges according to vehicle type by calling getTollCharges method
		Integer currentTollCharges = getTollCharges(currentVehicle.getVehicle_type());
		
		//finding the fastag by vehicle number
		for (Fastag f : fastags) {
			if (f.getVehicle_number().equals(currentVehicle.getVehicle_number())) {
				
				//assigning to currentVehiclefastag
				currentVehicleFastag = f;
				break;
			}
		}
		
		//if it is return journey then discount is given
		if (returnJourney) {
			currentTollCharges = currentTollCharges/2;
			discount = currentTollCharges;
		}
		
		//if we can't find fastag then that vehicle don't have fastag account
		//have to deduct the amount by cast and flat fee is added
		if (currentVehicleFastag == null) {
			total_amount_collected_via_cash = currentTollCharges;
			flat_fee_for_cash_payment = TollCharges.CASHFEE;
		}
		//if sufficient balance is there then deducting from fastag account
		else if(currentTollCharges <= currentVehicleFastag.getFastag_balance()) {
			total_amount_collected_via_fastag = currentTollCharges;
			currentVehicleFastag.setFastag_balance(currentVehicleFastag.getFastag_balance() - currentTollCharges);
		}
		// if no sufficient balance then difference is deducted from cash and flat fee is added
		else {
			Integer diffAmount = currentTollCharges - currentVehicleFastag.getFastag_balance();
			total_amount_collected_via_fastag = currentVehicleFastag.getFastag_balance();
			currentVehicleFastag.setFastag_balance(0);
			total_amount_collected_via_cash = diffAmount;
			flat_fee_for_cash_payment = TollCharges.CASHFEE;
		}
		
		//adding amounts to tollCollectionSummary account
		tollCollectionSummary.setTotal_amount_collected_via_fastag(total_amount_collected_via_fastag + 
				tollCollectionSummary.getTotal_amount_collected_via_fastag());
		
		tollCollectionSummary.setTotal_amount_collected_via_cash(total_amount_collected_via_cash + 
				tollCollectionSummary.getTotal_amount_collected_via_cash());
		
		tollCollectionSummary.setFlat_fee_for_cash_payment(flat_fee_for_cash_payment + 
				tollCollectionSummary.getFlat_fee_for_cash_payment());
		
		tollCollectionSummary.setDiscount(discount + 
				tollCollectionSummary.getDiscount());
		
		Integer totalCollection = total_amount_collected_via_fastag + total_amount_collected_via_cash + flat_fee_for_cash_payment;
		
		tollCollectionSummary.setTotal_amount_collected(totalCollection + tollCollectionSummary.getTotal_amount_collected());
		
		addVehicleSummary(totalCollection, currentVehicle.getVehicle_type(), tollCollectionSummary);
	}
	
	//Information according to the vehicle type, will be added to vehicleSummay entity
	public void addVehicleSummary (Integer total_collection, String vehicle_type, TollCollectionSummary tollCollectionSummary) {
		
		//getting all vehiclesummaries
		Set<VehicleSummary> vehicleSummaries = tollCollectionSummary.getVehicleSummary();
		
		//adding collection and journey to respective vehicletype
		for (VehicleSummary v : vehicleSummaries) {
			if (v.getVehicle_type().equals(vehicle_type)) {
				v.setTotal_collection(total_collection + v.getTotal_collection());
				v.setJourney(v.getJourney() + 1);
				break;
			}
		}
		
	}
	
	//For getting the toll charges as per vehicle type
	public Integer getTollCharges(String vehicle_type) {
		
		
		//initializing with default value
		Integer currentTollCharges = DefaultInitializer.INTEGER_INITIALIZER;
		
		//Assigning value as per vehicle type
		switch(vehicle_type) {
			case "TRUCK" : currentTollCharges = TollCharges.TRUCK;
			break;
			case "BUS" : currentTollCharges =  TollCharges.BUS;
			break;
			case "VAN" : currentTollCharges = TollCharges.VAN;
			break;
			case "CAR" : currentTollCharges = TollCharges.CAR;
			break;
			case "RICKSHAW" : currentTollCharges = TollCharges.RICKSHAW;
			break;
			case "SCOOTER" : currentTollCharges = TollCharges.SCOOTER;
			break;
			case "MOTORBIKE" : currentTollCharges = TollCharges.MOTORBIKE;
		}
		
		return currentTollCharges;
	}
}
