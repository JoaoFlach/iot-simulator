package com.joaoflach.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProducerChannelProperty {

	@Id
	private Long id;
	private String channelId;
	private String propertyName;
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
