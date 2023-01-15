package com.fastag.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fastag.dto.TollCollectionSummary;
import com.fastag.dto.VehicleSummary;

public class PrintCollectionService {

	//For printing the summary
	public String print (TollCollectionSummary tollCollectionSummary) {
		String ans = "";
		
		List<VehicleSummary> vehicleSummaries = new ArrayList<>(tollCollectionSummary.getVehicleSummary());
		vehicleSummaries.removeIf(v -> v.getTotal_collection() == 0);
    	Collections.sort(vehicleSummaries);
    	
        ans = "TOTAL_COLLECTION " + 
        		tollCollectionSummary.getTotal_amount_collected() + 
        		" " + 
        		tollCollectionSummary.getDiscount() + 
        		"\n" + "PAYMENT_SUMMARY " +
        		tollCollectionSummary.getTotal_amount_collected_via_fastag() + 
        		" " + 
        		(tollCollectionSummary.getTotal_amount_collected_via_cash() + tollCollectionSummary.getFlat_fee_for_cash_payment())
        		+ "\n" + "VEHICLE_TYPE_SUMMARY" + "\n";
        
        for (VehicleSummary v : vehicleSummaries) {
        	ans += v.getVehicle_type() + " " + v.getJourney() + "\n";
        }
		
		return ans;
	}
}
