package com.cts.dnb.Application1;

import java.util.Comparator;
import com.cts.dnb.model1.ExecutionGroupTYP;

public class EgTypComparator implements Comparator<ExecutionGroupTYP> {

	@Override
	public int compare(ExecutionGroupTYP eg1, ExecutionGroupTYP eg2) {
		return eg1.getExecutionGroupName().compareTo(eg2.getExecutionGroupName());
	}

}
