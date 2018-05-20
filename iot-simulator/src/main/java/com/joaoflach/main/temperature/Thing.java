package com.joaoflach.main.temperature;

import java.io.Serializable;
import java.util.Set;

public class Thing implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<Sensor> sensors;
	private Set<Actuator> actuators;
	private Location location;
	
	public Set<Sensor> getSensors() {
		return sensors;
	}
	
	public void setSensors(Set<Sensor> sensors) {
		this.sensors = sensors;
	}
	
	public Set<Actuator> getActuators() {
		return actuators;
	}
	
	public void setActuators(Set<Actuator> actuators) {
		this.actuators = actuators;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
			
	
}
