package com.example.demo.protocol;

public class VinData {
	private String Vin;
	private String carNum;
	private String carColor;
	private String carEngine;
	private String carType;
	private Long carId;
	
	
	public String getVin() {
		return Vin;
	}
	public void setVin(String vin) {
		Vin = vin;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarEngine() {
		return carEngine;
	}
	public void setCarEngine(String carEngine) {
		this.carEngine = carEngine;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}

}
