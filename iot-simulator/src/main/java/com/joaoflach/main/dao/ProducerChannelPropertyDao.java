package com.joaoflach.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joaoflach.main.entity.ProducerChannelProperty;

@Repository
public interface ProducerChannelPropertyDao extends CrudRepository<ProducerChannelProperty, Long>{

}
