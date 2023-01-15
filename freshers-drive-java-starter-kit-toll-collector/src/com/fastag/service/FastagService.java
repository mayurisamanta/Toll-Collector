package com.fastag.service;

import com.fastag.dto.TollCollectionSummary;
import com.fastag.entity.Fastag;

public class FastagService {

	//Adding new fastag with vehicle number and fastag balance
	public void addVehicle (String vehicle_number, Integer fastag_balance, TollCollectionSummary tollCollectionSummary) {
		
		Fastag newVehicle = new Fastag(vehicle_number, fastag_balance);
		
		tollCollectionSummary.getFastags().add(newVehicle);
	}
}
