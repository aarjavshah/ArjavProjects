package com.cts.dnb.Application2;

public class TopicProperties {
	private String topicName;
	private String topicString;
	private String topicDesc;
	private String pubAllowed;
	private String subAllowed;
	
	public TopicProperties() {
	}
	
	

	public TopicProperties(String topicName, String topicString,
			String topicDesc, String pubAllowed, String subAllowed) {
		super();
		this.topicName = topicName;
		this.topicString = topicString;
		this.topicDesc = topicDesc;
		this.pubAllowed = pubAllowed;
		this.subAllowed = subAllowed;
	}



	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicString() {
		return topicString;
	}
	public void setTopicString(String topicString) {
		this.topicString = topicString;
	}
	public String getTopicDesc() {
		return topicDesc;
	}
	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}
	public String getPubAllowed() {
		return pubAllowed;
	}
	public void setPubAllowed(String pubAllowed) {
		this.pubAllowed = pubAllowed;
	}
	public String getSubAllowed() {
		return subAllowed;
	}
	public void setSubAllowed(String subAllowed) {
		this.subAllowed = subAllowed;
	}
	
	
}
