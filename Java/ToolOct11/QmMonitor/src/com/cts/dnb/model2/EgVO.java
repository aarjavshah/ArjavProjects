package com.cts.dnb.model2;

import com.cts.dnb.model1.MessageFlowsTYP;

public class EgVO {
	private String Egname;
	private String deployedOn;
	private boolean AppStatus;
	MessageFlowsTYP msgflows;

	public EgVO(){
		
	}
	public EgVO(String egname, boolean appStatus) {
		super();
		Egname = egname;
		AppStatus = appStatus;
	}
	public String getEgname() {
		return Egname;
	}
	public void setEgname(String egname) {
		Egname = egname;
	}
	public String getDeployedOn() {
		return deployedOn;
	}
	public void setDeployedOn(String deployedOn) {
		this.deployedOn = deployedOn;
	}
	public boolean isAppStatus() {
		return AppStatus;
	}
	public void setAppStatus(boolean appStatus) {
		AppStatus = appStatus;
	}
	public MessageFlowsTYP getMsgflows() {
		return msgflows;
	}
	public void setMsgflows(MessageFlowsTYP msgflows) {
		this.msgflows = msgflows;
	}
	
}
