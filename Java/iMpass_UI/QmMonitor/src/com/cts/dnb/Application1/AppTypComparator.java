package com.cts.dnb.Application1;

import java.util.Comparator;

import com.cts.dnb.model1.ApplicationTYP;

public class AppTypComparator implements Comparator<ApplicationTYP> {

	@Override
	public int compare(ApplicationTYP app1, ApplicationTYP app2) {
		return app1.getApplicationName().compareTo(app2.getApplicationName());
	}

}
