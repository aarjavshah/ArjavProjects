package com.cts.iot;

public class QMConnectionParmsVO {
	private String hostname;
	private int port;
	private String channel;
	private String queueManager;
	private String queue;
	
	public QMConnectionParmsVO(String hostname, int port, String channel,
			String queueManager, String queue) {
		super();
		this.hostname = hostname;
		this.port = port;
		this.channel = channel;
		this.queueManager = queueManager;
		this.queue = queue;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getQueueManager() {
		return queueManager;
	}

	public void setQueueManager(String queueManager) {
		this.queueManager = queueManager;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}
	
	
}
