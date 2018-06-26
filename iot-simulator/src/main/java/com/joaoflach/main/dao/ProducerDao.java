package com.joaoflach.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joaoflach.main.entity.Producer;

@Repository
public interface ProducerDao extends CrudRepository<Producer, Long>{

}
