package com.cts.dnb.Application1;

public class MyRunnableBkrStatusUpdate  implements Runnable {
    private String reqID;
    private String userName;
    public MyRunnableBkrStatusUpdate(String reqID,String userName) {
       this.reqID = reqID;
       this.userName = userName;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BrokerStatusUpdate.startBrokerStatusUpadate(reqID,userName);
	}
}
