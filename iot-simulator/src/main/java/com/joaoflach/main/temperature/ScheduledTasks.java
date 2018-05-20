package com.joaoflach.main.temperature;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
    private HumhubProcessor humhubProcessor;

    @Autowired
	private UserDao userDao;
      
    @Scheduled(fixedRate = 5000)
    public void alterTemperatures() {
    	log.debug("alterTemperatures start");
    	for(Map.Entry<Long, Arduino> arduino : 
        	Database.INSTANCE.getArduinoDatabase().entrySet()) {
        	log.debug("Altering temperature for Arduino ID: {}", arduino.getKey());
        	arduino.getValue().alterTemperature();
        }
    	
    	log.debug("alterTemperatures end");
    }
    
    @Scheduled(fixedDelay = 2000)
    private void humhubExecutor(){
    	
    	String[] l = {"a","b","c"};
		Arrays.asList(l).forEach(i -> {
			humhubProcessor.process(i);
		});
    	
    }
}
