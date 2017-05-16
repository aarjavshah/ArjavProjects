package com.cts.dnb.Application1;

import com.cts.dnb.AdminService.LoadQMObjectsUtility;

public class MyRunnableBkrStatusUpdate  implements Runnable {
    private String reqID;
    public MyRunnableBkrStatusUpdate(String reqID) {
       this.reqID = reqID;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BrokerStatusUpdate.startBrokerStatusUpadate(reqID);
	}
}
