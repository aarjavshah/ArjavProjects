package com.cts.iot;

public class StatusVO {
	private boolean acStatus;
	private boolean heaterStatus;
	private boolean lightStatus;
	public StatusVO(){}
	public StatusVO(boolean acStatus, boolean heaterStatus, boolean lightStatus) {
		super();
		this.acStatus = acStatus;
		this.heaterStatus = heaterStatus;
		this.lightStatus = lightStatus;
	}
	public boolean isLightStatus() {
		return lightStatus;
	}
	public void setLightStatus(boolean lightStatus) {
		this.lightStatus = lightStatus;
	}
	public boolean isAcStatus() {
		return acStatus;
	}
	public void setAcStatus(boolean acStatus) {
		this.acStatus = acStatus;
	}
	public boolean isHeaterStatus() {
		return heaterStatus;
	}
	public void setHeaterStatus(boolean heaterStatus) {
		this.heaterStatus = heaterStatus;
	}
	
}
