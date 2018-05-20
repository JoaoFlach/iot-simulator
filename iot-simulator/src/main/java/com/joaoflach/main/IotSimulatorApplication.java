package com.joaoflach.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.joaoflach.main.temperature.Arduino;
import com.joaoflach.main.temperature.Database;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class IotSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotSimulatorApplication.class, args);
		Database.INSTANCE.insertArduino(new Arduino("Arduino1"));
		Database.INSTANCE.insertArduino(new Arduino("Arduino2"));
		Database.INSTANCE.insertArduino(new Arduino("Arduino3"));
		Database.INSTANCE.insertArduino(new Arduino("Arduino4"));
		Database.INSTANCE.insertArduino(new Arduino("Arduino5"));
		Database.INSTANCE.insertArduino(new Arduino("Arduino6"));
	}
}
