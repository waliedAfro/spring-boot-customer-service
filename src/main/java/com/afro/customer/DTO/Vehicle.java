package com.afro.customer.DTO;

public class Vehicle {
	
	private Long vehicleId ; 
	private String chassiNo ; 
	private String brand ; 
	private String model ; 
	private Long customerId ;
	
	public Long getVehicleId() {
		return vehicleId;
	}
	public String getChassiNo() {
		return chassiNo;
	}
	public String getBrand() {
		return brand;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", chassiNo=" + chassiNo + ", brand=" + brand + ", model=" + model
				+ ", customerId=" + customerId + "]";
	}
	public String getModel() {
		return model;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public void setChassiNo(String chassiNo) {
		this.chassiNo = chassiNo;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	

}
