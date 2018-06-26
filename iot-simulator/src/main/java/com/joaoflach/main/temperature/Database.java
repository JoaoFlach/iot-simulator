package com.joaoflach.main.temperature;

import java.util.HashMap;
import java.util.Map;

public enum Database {
	INSTANCE;
	
	private Map<Long, Thing> thingDatabase = new HashMap<>();
	private Map<Long, Arduino> arduinoDatabase = new HashMap<>();
	private Boolean airConditionerStatus = true;
	private Long counter = 0L;
	private Long arduinoCounter = 0L;

	public Thing selectThingById(Long id) {
		return thingDatabase.get(id);
	}
	
	public void insertThing(Thing thing) {
		counter++;
		thingDatabase.put(counter, thing);
	}
	
	public Arduino selectArduinoById(Long id) {
		return arduinoDatabase.get(id);
	}
	
	public void insertArduino(Arduino arduino) {
		arduinoCounter++;
		arduinoDatabase.put(arduinoCounter, arduino);
	}
	
	public Map<Long, Arduino> getArduinoDatabase() {
		return arduinoDatabase;
	}
	
	public void turnAirConditionerOn() {
		this.airConditionerStatus=true;
	}
	
	public void turnAirConditionerOff() {
		this.airConditionerStatus=false;
	}
	
	public Boolean airConditionerStatus() {
		return this.airConditionerStatus;
	}
	
}
