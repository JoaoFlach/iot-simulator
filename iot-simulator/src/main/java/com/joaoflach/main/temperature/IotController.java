package com.joaoflach.main.temperature;
import java.io.Serializable;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IotController {
	

	@RequestMapping("/insert/{name}") 
	public void insertArduino(@PathVariable String name){		
		Database.INSTANCE.insertArduino(new Arduino(name));
	}
	
	@RequestMapping(value = "/select", method=RequestMethod.GET) 
	public Arduino selectArduinoById(@RequestParam Long id){
		return Database.INSTANCE.selectArduinoById(id);
	}
	
	@RequestMapping(value = "/light", method=RequestMethod.GET) 
	public ResponseEntity selectLightById(@RequestParam Long id){
		Arduino arduino = Database.INSTANCE.selectArduinoById(id);
		
		return new ResponseEntity<>(arduino.getLight(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/temperature", method=RequestMethod.GET) 
	public ResponseEntity selectTemperatureById(@RequestParam Long id){
		Arduino arduino = Database.INSTANCE.selectArduinoById(id);
		
		return new ResponseEntity<>(arduino.getTemperature(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/light/color", method=RequestMethod.POST) 
	public ResponseEntity setLightColor(@RequestParam Long id, @RequestBody String color){
		Arduino arduino = Database.INSTANCE.selectArduinoById(id);
		arduino.getLight().setColor(color);
		
		return new ResponseEntity<>(arduino.getLight(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/select/all", method=RequestMethod.GET) 
	public ResponseEntity selectArduino(){
		return new ResponseEntity<>(Database.INSTANCE.getArduinoDatabase(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/turnlight", method=RequestMethod.POST)
	public Arduino changeArduinoState(@RequestParam Long id){
		Arduino arduino = Database.INSTANCE.selectArduinoById(id);
		arduino.turnLight();
		return arduino;
	}
	
}
