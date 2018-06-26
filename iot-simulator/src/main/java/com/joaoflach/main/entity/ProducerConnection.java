package com.joaoflach.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProducerConnection {

	@Id
	private Long id;
	private Long producerId;
	private Long originChannelId;
	private Long whenProperty;
	private String conditionSign;
	private String conditionValue;
	private String createdAt;
	private String updatedAt;
	private Long thenId;
	private String postContent;
	private Long postChannelId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProducerId() {
		return producerId;
	}
	public void setProducerId(Long producerId) {
		this.producerId = producerId;
	}
	public Long getOriginChannelId() {
		return originChannelId;
	}
	public void setOriginChannelId(Long originChannelId) {
		this.originChannelId = originChannelId;
	}
	public Long getWhenProperty() {
		return whenProperty;
	}
	public void setWhenProperty(Long whenProperty) {
		this.whenProperty = whenProperty;
	}
	public String getConditionSign() {
		return conditionSign;
	}
	public void setConditionSign(String conditionSign) {
		this.conditionSign = conditionSign;
	}
	public String getConditionValue() {
		return conditionValue;
	}
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getThenId() {
		return thenId;
	}
	public void setThenId(Long thenId) {
		this.thenId = thenId;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Long getPostChannelId() {
		return postChannelId;
	}
	public void setPostChannelId(Long postChannelId) {
		this.postChannelId = postChannelId;
	}
	@Override
	public String toString() {
		return "ProducerConnection [id=" + id + ", producerId=" + producerId + ", originChannelId=" + originChannelId
				+ ", whenProperty=" + whenProperty + ", conditionSign=" + conditionSign + ", conditionValue="
				+ conditionValue + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", thenId=" + thenId
				+ ", postContent=" + postContent + ", postChannelId=" + postChannelId + "]";
	}

	
	
}
