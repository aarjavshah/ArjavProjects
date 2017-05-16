package com.cts.dnb.Application1;

import java.util.Comparator;

import com.cts.dnb.model2.ApplicationVO;

public class ApplicationVOComparator implements Comparator<ApplicationVO> {
	
	@Override
	public int compare(ApplicationVO app1,ApplicationVO app2){
		return app1.getApplicationName().compareTo(app2.getApplicationName());
	}
}
