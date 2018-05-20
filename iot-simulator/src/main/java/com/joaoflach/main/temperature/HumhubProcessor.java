package com.joaoflach.main.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HumhubProcessor {
	private static final Logger log = LoggerFactory.getLogger(HumhubProcessor.class);

	@Async("asyncTaskExecutor")
	public void process(String i) {
		log.debug("started process {}", i);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			log.error("deu erro");
		}
		log.debug("ended process");
	}

}
