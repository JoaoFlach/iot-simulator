package com.joaoflach.main.temperature;

import java.io.Serializable;

public class Temperature implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long celsius;
	
	public Temperature() {
		this.celsius = 0L;
	}
	
	public Long getCelsius() {
		return celsius;
	}	
	public void setCelsius(long celsius) {
		this.celsius = celsius;
	}
	
	
	
	
	
}
