package com.fastag.dto;

import java.util.HashSet;
import java.util.Set;

import com.fastag.entity.Fastag;
import com.fastag.entity.Vehicle;

//Here all the details of single testcase will be stored
public class TollCollectionSummary {

	private Integer total_amount_collected_via_fastag = 0; 
	
	private Integer total_amount_collected_via_cash = 0; 
	
	private Integer flat_fee_for_cash_payment = 0;
	
	private Integer discount = 0;
	
	private Integer total_amount_collected = 0;
	
	private Set<Fastag> fastags = new HashSet<>();
	
	private Set<Vehicle> vehicles = new HashSet<>();
	
	private Set<VehicleSummary> vehicleSummary = new HashSet<>();

	public TollCollectionSummary() {
		super();
		vehicleSummary.add(new VehicleSummary("TRUCK", 0, 0));
		vehicleSummary.add(new VehicleSummary("BUS", 0, 0));
		vehicleSummary.add(new VehicleSummary("VAN", 0, 0));
		vehicleSummary.add(new VehicleSummary("CAR", 0, 0));
		vehicleSummary.add(new VehicleSummary("RICKSHAW", 0, 0));
		vehicleSummary.add(new VehicleSummary("SCOOTER", 0, 0));
		vehicleSummary.add(new VehicleSummary("MOTORBIKE", 0, 0));
	}

	public Integer getTotal_amount_collected_via_fastag() {
		return total_amount_collected_via_fastag;
	}

	public void setTotal_amount_collected_via_fastag(Integer total_amount_collected_via_fastag) {
		this.total_amount_collected_via_fastag = total_amount_collected_via_fastag;
	}

	public Integer getTotal_amount_collected_via_cash() {
		return total_amount_collected_via_cash;
	}

	public void setTotal_amount_collected_via_cash(Integer total_amount_collected_via_cash) {
		this.total_amount_collected_via_cash = total_amount_collected_via_cash;
	}

	public Integer getFlat_fee_for_cash_payment() {
		return flat_fee_for_cash_payment;
	}

	public void setFlat_fee_for_cash_payment(Integer flat_fee_for_cash_payment) {
		this.flat_fee_for_cash_payment = flat_fee_for_cash_payment;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getTotal_amount_collected() {
		return total_amount_collected;
	}

	public void setTotal_amount_collected(Integer total_amount_collected) {
		this.total_amount_collected = total_amount_collected;
	}

	public Set<Fastag> getFastags() {
		return fastags;
	}

	public void setFastags(Set<Fastag> fastags) {
		this.fastags = fastags;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Set<VehicleSummary> getVehicleSummary() {
		return vehicleSummary;
	}

	public void setVehicleSummary(Set<VehicleSummary> vehicleSummary) {
		this.vehicleSummary = vehicleSummary;
	}
	
}
