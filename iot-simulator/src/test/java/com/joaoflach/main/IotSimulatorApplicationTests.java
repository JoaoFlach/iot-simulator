package com.joaoflach.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.joaoflach.main.temperature.ScheduledTasks;
import com.joaoflach.main.temperature.User;
import com.joaoflach.main.temperature.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IotSimulatorApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(IotSimulatorApplicationTests.class);
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void contextLoads() {
		Iterable<User> users = userDao.findAll();
		users.forEach(this::logUserInfo);
	}
	
	private void logUserInfo(User user) {
		log.info("user {}", user);
	}
	
	

}
