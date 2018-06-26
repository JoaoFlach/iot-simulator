package com.joaoflach.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoflach.main.dao.ProducerConnectionDao;
import com.joaoflach.main.entity.ProducerConnection;

@RestController 
public class ProducerConnectionController {
    private static final Logger log = LoggerFactory.getLogger(ProducerConnectionController.class);

    @Autowired
    private ProducerConnectionDao dao;
    
	@RequestMapping("/humhub/producerconnection")
	public ResponseEntity getAllRecords() {
		List<ProducerConnection> records = (List) dao.findAll();
		return new ResponseEntity<>(records, HttpStatus.OK);
	}

}
