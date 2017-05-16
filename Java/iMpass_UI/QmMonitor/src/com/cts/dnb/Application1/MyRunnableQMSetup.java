package com.cts.dnb.Application1;

import com.cts.dnb.AdminService.LoadQMObjectsUtility;

public class MyRunnableQMSetup implements Runnable {
	      private String reqID;
	      private String username;
	      public MyRunnableQMSetup(String reqID,String username) {
	         this.reqID = reqID;
	         this.username = username;
	      }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			LoadQMObjectsUtility.startQMUpdate(reqID,username);
		}
}
