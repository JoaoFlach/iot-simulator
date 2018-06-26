package com.joaoflach.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joaoflach.main.scheduled.ScheduledTasks;
import com.joaoflach.main.temperature.Database;

@RestController 
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@RequestMapping(value="/house/airconditioner/1", method=RequestMethod.GET)
	public ResponseEntity airCondStatus() {
		return ghj();
	}
	
	@RequestMapping(value="/house/airconditioner/1/on", method=RequestMethod.POST)
	public ResponseEntity turnOnAirCond() {
		Database.INSTANCE.turnAirConditionerOn();
		return ghj();
	}
	
	@RequestMapping(value="/house/airconditioner/1/off", method=RequestMethod.POST)
	public ResponseEntity turnOffAirCond() {
		Database.INSTANCE.turnAirConditionerOff();
		return ghj();
	}
	
	private ResponseEntity ghj() {
		Map<String, Boolean> map = new HashMap<>();
		map.put("isOn",Database.INSTANCE.airConditionerStatus());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
