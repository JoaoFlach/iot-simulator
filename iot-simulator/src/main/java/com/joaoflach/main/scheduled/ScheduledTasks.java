package com.joaoflach.main.scheduled;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.joaoflach.main.dao.ProducerConnectionDao;
import com.joaoflach.main.process.HumhubProcessor;
import com.joaoflach.main.temperature.Arduino;
import com.joaoflach.main.temperature.Database;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
    private HumhubProcessor humhubProcessor;

    @Autowired
    private ProducerConnectionDao producerConnectionDao;
      
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
    	producerConnectionDao.findAll().forEach(i -> {
			humhubProcessor.executeProducerConnection(i);
		});
    }
}
