package com.joaoflach.main.temperature;

import java.io.Serializable;

public class Light implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LightStatusEnum status;
	private String color;
	
	public Light(LightStatusEnum status){
		this.status = status;
		this.color = "WHITE";
	}
	
	public LightStatusEnum getStatus(){
		return status;
	}
	
	public void setStatus(LightStatusEnum status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
