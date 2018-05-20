package com.joaoflach.main.temperature;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Arduino implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Light light = new Light(false); 
	private Temperature temperature = new Temperature();
	
	public Arduino (String name) {
		this.name=name;
	}
	
	public Temperature getTemperature () {		
		return temperature;
	}
	
	public void alterTemperature() {
		temperature.setCelsius(ThreadLocalRandom.current().nextLong(-40, 50));
	}

	public Light getLight () {
		return light;
	}
	
	public void turnLight() {
		light.setStatus(!light.getStatus());
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
