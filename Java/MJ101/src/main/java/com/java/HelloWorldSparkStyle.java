package com.java;
import spark.*;
public class HelloWorldSparkStyle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spark.get("/", new Route() {
			
			public Object handle(Request arg0, Response arg1) throws Exception {
				// TODO Auto-generated method stub
				return HelloWorldFreeMarker.getWebPage();
			}
		});
		Spark.get("/rje/:arjav", new Route() {
			
			public Object handle(Request arg0, Response arg1) throws Exception {
				// TODO Auto-generated method stub
				return arg0.params(":arjav");
			}
		});
		Spark.post("/chooseColor", new Route() {
			
			public Object handle(Request arg0, Response arg1) throws Exception {
				// TODO Auto-generated method stub
				String clr = arg0.queryParams("color");
				if(clr==null){
					return "Vikalp maro bapo pasand kare??";
				}else{
					return "Pikina tane "+ clr+" rang game, em ne??";		
				}
			
			}
		});
	}

}
