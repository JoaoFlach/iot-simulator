package com.joaoflach.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joaoflach.main.entity.ProducerConnection;

@Repository
public interface ProducerConnectionDao extends CrudRepository<ProducerConnection, Long>{

}
