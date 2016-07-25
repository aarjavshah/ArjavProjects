package com.cts.iot;

public class Test {

	public static void main(String[] args) {
		//StatusVO vo = ReadStatus.GetStatus();
		//System.out.println("AC : "+vo.isAcStatus()+"\nHeater : "+vo.isHeaterStatus());
//		System.out.println(GenerateJSON.ConvertToJSON(new SensorInputVO(25, 150, 3)));
		QMConnectionParmsVO qmVO = new QMConnectionParmsVO("localhost", 1415, "SYSTEM.DEF.SVRCONN", "QM2", "Q1");
		PutMessage.PutMessageToQueue(qmVO, GenerateJSON.ConvertToJSON(new SensorInputVO(25, 150, 3)));
	}

}
