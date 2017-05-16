package com.cts.dnb.model2;

import java.util.ArrayList;

public class ApplicationVO {

	private String applicationName;
	private ArrayList<EgVO> EgList;
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public ArrayList<EgVO> getEgList() {
		return EgList;
	}
	public void setEgList(ArrayList<EgVO> egList) {
		EgList = egList;
	}
	
}
