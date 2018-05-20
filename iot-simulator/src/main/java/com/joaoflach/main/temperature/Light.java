package com.joaoflach.main.temperature;

import java.io.Serializable;

public class Light implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean status;
	private String color;
	
	public Light(boolean status){
		this.status = status;
		this.color = "WHITE";
	}
	
	public boolean getStatus(){
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
