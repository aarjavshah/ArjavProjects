package com.cts.iot;

public class SensorInputVO {
	private int temp;
	private int light;
	private int motion;
	public SensorInputVO() {}
	public SensorInputVO(int temp, int light, int motion) {
		super();
		this.temp = temp;
		this.light = light;
		this.motion = motion;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getLight() {
		return light;
	}
	public void setLight(int light) {
		this.light = light;
	}
	public int getMotion() {
		return motion;
	}
	public void setMotion(int motion) {
		this.motion = motion;
	}
	
	
}
