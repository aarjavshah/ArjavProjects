package com.cts.dnb.Application1;

import java.util.ArrayList;

import com.cts.dnb.model1.ApplicationTYP;
import com.cts.dnb.model1.BrokerTYP;
import com.cts.dnb.model1.BrokersTYP;
import com.cts.dnb.model1.ExecutionGroupTYP;
import com.cts.dnb.model1.ExecutionGroupsTYP;
import com.cts.dnb.model2.ApplicationVO;
import com.cts.dnb.model2.EgVO;

public class ApplicationUnderBroker {
	
	public static ArrayList<ApplicationVO> GetApplicationsForBroker(String brokerName){
		ArrayList<ApplicationVO> applicationVo = new ArrayList <ApplicationVO>();
		BrokersTYP  brokers =  jaxB.getjaxbObject();
		for(BrokerTYP b : brokers.getBroker()){
			if(b.getBrokerName().equals(brokerName)){
			ExecutionGroupsTYP egs = b.getExecutionGroups();
			for(ExecutionGroupTYP eg :egs.getExecutionGroup()){
				for(ApplicationTYP app:eg.getApplications().getApplication()){
					boolean flag=false;
					for(int i=0;i<applicationVo.size();i++){
						ApplicationVO x = applicationVo.get(i);
						if(x.getApplicationName().equals(app.getApplicationName())){
							flag=true;
							ArrayList<EgVO> EgList = new ArrayList<EgVO>();
							EgList = x.getEgList();
							EgVO eg1 = new EgVO();
							eg1.setAppStatus(app.isIsApplicationRunning());
							eg1.setDeployedOn(app.getApplicationDeployedOn());
							eg1.setEgname(eg.getExecutionGroupName());
							eg1.setMsgflows(app.getMessageFlows());
							EgList.add(eg1);
							x.setEgList(EgList);
							applicationVo.set(i, x);
							}
						}
						if(!flag){
							ApplicationVO app1 = new ApplicationVO();
							EgVO eg1 = new EgVO();
							eg1.setAppStatus(app.isIsApplicationRunning());
							eg1.setDeployedOn(app.getApplicationDeployedOn());
							eg1.setEgname(eg.getExecutionGroupName());
							eg1.setMsgflows(app.getMessageFlows());
							ArrayList<EgVO> EgList = new ArrayList<EgVO>();
							EgList.add(eg1);
							app1.setApplicationName(app.getApplicationName());
							app1.setEgList(EgList);
							applicationVo.add(app1);
						}
					}
				}
			}
		}
		return applicationVo;
	}
}
