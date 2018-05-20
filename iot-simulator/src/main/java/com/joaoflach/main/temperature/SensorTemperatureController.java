package com.joaoflach.main.temperature;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorTemperatureController {

	
	
	@RequestMapping("/temperature")
	public SensorTemperatureModel getTemperatureData() {
		SensorTemperatureModel stm = new SensorTemperatureModel();
		stm.setCelsius("32");
		return stm;
	}
}
