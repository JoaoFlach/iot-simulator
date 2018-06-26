package com.joaoflach.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joaoflach.main.entity.ProducerChannel;

@Repository
public interface ProducerChannelDao extends CrudRepository<ProducerChannel, Long>{

}
