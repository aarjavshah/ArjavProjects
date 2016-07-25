package com.rje.ams.test;

import com.rje.ams.dao.AssetDAO;
import com.rje.ams.dao.LendingDAO;
import com.rje.ams.vo.AssetDetailsVO;
import com.rje.ams.vo.LendingDetailsVO;


public class TestAddAsset {

	public static void main(String[] args) {
//		AssetDetailsVO vo = new AssetDetailsVO("PM101", "Blending Machine Airlock", "MPSH-22/22-LP-TK1", "Buhler", "459421", "FBL (TS) FACTORY",true);
		
//		AssetDetailsVO vo = new AssetDetailsVO("LB102", "Blending Machine Airlock", "MPSH-22/22-LP-TK1", "Buhler", "459421", "FBL (TS) FACTORY",true);
//		LendingDetailsVO vo = new LendingDetailsVO("20160428102518122", "PM101", "454582", "2016-04-28", "10:26", null, null, 0);
		
//		LendingDetailsVO vo = new LendingDetailsVO("20160428102518122", "PM101", "454582", "2016-04-28", "10:26", "2016-04-28", "13:06", 1);
		System.out.println(AssetDAO.CountAssets()+" assets are available in the inventory.");
		AssetDetailsVO vo = new AssetDetailsVO("LB101", "Blending Machine Airlock", "MPSH-22/22-LP-TK1", "Buhler", "459421", "FBL (TS) FACTORY",true);
		System.out.println(AssetDAO.AddAsset(vo)+" new asset(s) added to the invetory.");
		System.out.println(AssetDAO.CountAssets()+" assets are available in the inventory.");
		
		
	}

}
