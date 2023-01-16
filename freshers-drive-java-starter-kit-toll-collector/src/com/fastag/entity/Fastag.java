package com.fastag.entity;

import java.util.Objects;

// It include the vehicle number and fastag balance i.e fastag account of particular vehicle
public class Fastag {

	private String vehicle_number;
	
	private Integer fastag_balance;

	public Fastag() {
		super();
	}

	public Fastag(String vehicle_number, Integer fastag_balance) {
		super();
		this.vehicle_number = vehicle_number;
		this.fastag_balance = fastag_balance;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public Integer getFastag_balance() {
		return fastag_balance;
	}

	public void setFastag_balance(Integer fastag_balance) {
		this.fastag_balance = fastag_balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fastag_balance, vehicle_number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fastag other = (Fastag) obj;
		return Objects.equals(fastag_balance, other.fastag_balance)
				&& Objects.equals(vehicle_number, other.vehicle_number);
	}

	@Override
	public String toString() {
		return "Fastag [vehicle_number=" + vehicle_number + ", fastag_balance=" + fastag_balance + "]";
	}

}
