package com.cts.dnb.Application1;

import com.cts.dnb.AdminService.LoadQMObjectsUtility;

public class MyRunnableQMSetup implements Runnable {
	      private String reqID;
	      public MyRunnableQMSetup(String reqID) {
	         this.reqID = reqID;
	      }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			LoadQMObjectsUtility.startQMUpdate(reqID);
		}
}
