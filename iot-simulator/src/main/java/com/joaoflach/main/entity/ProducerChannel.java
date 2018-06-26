package com.joaoflach.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProducerChannel {

	@Id
	private Long id;
	private String httpMethod;
	private String name;
	private String internetAddress;
	private String payloadSchema;
	private Long producerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternetAddress() {
		return internetAddress;
	}

	public void setInternetAddress(String internetAddress) {
		this.internetAddress = internetAddress;
	}

	public String getPayload_schema() {
		return payloadSchema;
	}

	public void setPayload_schema(String payload_schema) {
		this.payloadSchema = payload_schema;
	}

	public Long getProducerId() {
		return producerId;
	}

	public void setProducerId(Long producer_id) {
		this.producerId = producer_id;
	}

}
