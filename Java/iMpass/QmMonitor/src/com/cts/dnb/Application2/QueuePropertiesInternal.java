package com.cts.dnb.Application2;

public class QueuePropertiesInternal {
	public static final int LOCAL_QUEUE= 1;
	public static final int REMOTE_QUEUE= 6;
	public static final int ALIAS_QUEUE= 3;
	private int queueDepth;
	private int openInputCount;
	private int openOutputCount;
	private int maxDepth;
	private int inhibitPutMessage;
	private int inhibitGetMessage;
	private int queueType;
	
	public int getQueueDepth() {
		return queueDepth;
	}
	public void setQueueDepth(int queueDepth) {
		this.queueDepth = queueDepth;
	}
	public int getOpenInputCount() {
		return openInputCount;
	}
	public void setOpenInputCount(int openInputCount) {
		this.openInputCount = openInputCount;
	}
	public int getOpenOutputCount() {
		return openOutputCount;
	}
	public void setOpenOutputCount(int openOutputCount) {
		this.openOutputCount = openOutputCount;
	}
	public int getMaxDepth() {
		return maxDepth;
	}
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}
	public int getInhibitPutMessage() {
		return inhibitPutMessage;
	}
	public void setInhibitPutMessage(int inhibitPutMessage) {
		this.inhibitPutMessage = inhibitPutMessage;
	}
	public int getInhibitGetMessage() {
		return inhibitGetMessage;
	}
	public void setInhibitGetMessage(int inhibitGetMessage) {
		this.inhibitGetMessage = inhibitGetMessage;
	}
	public static int getLocalQueue() {
		return LOCAL_QUEUE;
	}
	public static int getRemoteQueue() {
		return REMOTE_QUEUE;
	}
	public static int getAliasQueue() {
		return ALIAS_QUEUE;
	}
	public int getQueueType() {
		return queueType;
	}
	public void setQueueType(int queueType) {
		this.queueType = queueType;
	}
}
