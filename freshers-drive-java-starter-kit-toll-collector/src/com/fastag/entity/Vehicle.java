package com.fastag.entity;

// It include the vehicle type, vehicle number and journeys 
public class Vehicle {

	private String vehicle_type;
	
	private String vehicle_number;
	
	private Integer journeys;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String vehicle_type, String vehicle_number, Integer journeys) {
		super();
		this.vehicle_type = vehicle_type;
		this.vehicle_number = vehicle_number;
		this.journeys = journeys;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public Integer getJourneys() {
		return journeys;
	}

	public void setJourneys(Integer journeys) {
		this.journeys = journeys;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle_type=" + vehicle_type + ", vehicle_number=" + vehicle_number + ", journeys=" + journeys
				+ "]";
	}
	
}
