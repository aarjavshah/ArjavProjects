package com.cts.dnb.Application2;

import java.util.ArrayList;
import java.util.List;

public class QueueProperties {
	private String queueName;
	private String queueType;
	private String inhibitPutMessage;
	private String inhibitGetMessage;
	private int maxDepth;
	private String targetQ;
	private String remoteQM;
	private String remoteQ;
	private int curDepth;
	private int openInputCount;
	private int openOutputCount;
	private String lastGetDt;
	private String lastGetTm;
	private String lastPutDt;
	private String lastPutTm;
	private ArrayList<QueueListener> listenerList;
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	public String getQueueType() {
		return queueType;
	}
	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}
	public String getInhibitPutMessage() {
		return inhibitPutMessage;
	}
	public void setInhibitPutMessage(String inhibitPutMessage) {
		this.inhibitPutMessage = inhibitPutMessage;
	}
	public String getInhibitGetMessage() {
		return inhibitGetMessage;
	}
	public void setInhibitGetMessage(String inhibitGetMessage) {
		this.inhibitGetMessage = inhibitGetMessage;
	}
	public int getMaxDepth() {
		return maxDepth;
	}
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}
	public String getTargetQ() {
		return targetQ;
	}
	public void setTargetQ(String targetQ) {
		this.targetQ = targetQ;
	}
	public String getRemoteQM() {
		return remoteQM;
	}
	public void setRemoteQM(String remoteQM) {
		this.remoteQM = remoteQM;
	}
	public String getRemoteQ() {
		return remoteQ;
	}
	public void setRemoteQ(String remoteQ) {
		this.remoteQ = remoteQ;
	}
	public int getCurDepth() {
		return curDepth;
	}
	public void setCurDepth(int curDepth) {
		this.curDepth = curDepth;
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
	public String getLastGetDt() {
		return lastGetDt;
	}
	public void setLastGetDt(String lastGetDt) {
		this.lastGetDt = lastGetDt;
	}
	public String getLastGetTm() {
		return lastGetTm;
	}
	public void setLastGetTm(String lastGetTm) {
		this.lastGetTm = lastGetTm;
	}
	public String getLastPutDt() {
		return lastPutDt;
	}
	public void setLastPutDt(String lastPutDt) {
		this.lastPutDt = lastPutDt;
	}
	public String getLastPutTm() {
		return lastPutTm;
	}
	public void setLastPutTm(String lastPutTm) {
		this.lastPutTm = lastPutTm;
	}
	public ArrayList<QueueListener> getListenerList() {
		return listenerList;
	}
	public void setListenerList(ArrayList<QueueListener> listenerList) {
		this.listenerList = listenerList;
	}
	
	
	
}
