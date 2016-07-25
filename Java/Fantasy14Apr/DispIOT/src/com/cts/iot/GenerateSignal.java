package com.cts.iot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

public class GenerateSignal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int temp = Integer.parseInt(request.getParameter("temp"));
		int light = Integer.parseInt(request.getParameter("light"));
		int motion = Integer.parseInt(request.getParameter("motion"));
		SensorInputVO vo = new SensorInputVO(temp, light, motion);
		//System.out.println("temp:"+temp+"\nlight:"+light+"\nmotion:"+motion+"\n\n\n");
		QMConnectionParmsVO qmVO = new QMConnectionParmsVO("localhost", 1415, "SYSTEM.DEF.SVRCONN", "QM2", "Q1");
		PutMessage.PutMessageToQueue(qmVO, GenerateJSON.ConvertToJSON(vo));
		session.setAttribute("prevRead", vo);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("IOTSensorSimulator.jsp");
	}

}
