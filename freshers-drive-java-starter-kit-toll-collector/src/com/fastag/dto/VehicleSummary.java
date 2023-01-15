package com.fastag.dto;

//As per vehicle type, total collection and journey will be stored
public class VehicleSummary implements Comparable<VehicleSummary>{

	private String vehicle_type;
	
	private Integer total_collection;
	
	private Integer journey;

	public VehicleSummary() {
		super();
	}

	public VehicleSummary(String vehicle_type, Integer total_collection, Integer journey) {
		super();
		this.vehicle_type = vehicle_type;
		this.total_collection = total_collection;
		this.journey = journey;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public Integer getTotal_collection() {
		return total_collection;
	}

	public void setTotal_collection(Integer total_collection) {
		this.total_collection = total_collection;
	}

	public Integer getJourney() {
		return journey;
	}

	public void setJourney(Integer journey) {
		this.journey = journey;
	}

	@Override
	public int compareTo(VehicleSummary o) {
		if (this.total_collection == o.getTotal_collection()) {
			return this.vehicle_type.compareTo(o.getVehicle_type());
			
		}
		else return o.getTotal_collection() - this.total_collection;
	}

	@Override
	public String toString() {
		return "VehicleSummary [vehicle_type=" + vehicle_type + ", total_collection=" + total_collection + ", journey="
				+ journey + "]";
	}
	
}
