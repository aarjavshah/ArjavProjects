package com.cts.nfl.pcalc;

import com.cts.nfl.vo.MatchPredictVO;

public class PointCalculator {

	public static int CalculateMatchPoints(MatchPredictVO predict){
		int points=0;
		//toss winner gets +100 and loser get -100
		if(predict.isToss()){
			points+=100;
		}else{
			points-=100;
		}
		//matchwinner gets +250 loser gets -250
		if(predict.isWinner()){
			if(predict.getMatchNo()<=56){
				points+=250;
			}else if(predict.getMatchNo()>56 && predict.getMatchNo()<60){
				points+=350;
			}else{
				points+=450;
			}
		}else{
			if(predict.getMatchNo()<=56){
				points-=250;
			}else if(predict.getMatchNo()>56 && predict.getMatchNo()<60){
				points-=350;
			}else{
				points-=450;
			}
		}
		//adds points according to team1 run prediction
		points+=PointCalculator.CalculateRunPoints(predict.getTeam1Run());
		//adds points according to team2 run prediction
		points+=PointCalculator.CalculateRunPoints(predict.getTeam2Run());
		//adds points according to team1 wicket prediction
		points+=PointCalculator.CalculateWktPoints(predict.getTeam1Wkt());
		//adds points according to team1 wicket prediction
		points+=PointCalculator.CalculateWktPoints(predict.getTeam2Wkt());
		
		return points;
	}
	
	public static int CalculateRunPoints(int runDif){
		int runPoint=0;
		switch(runDif){
			case 0:
				runPoint=150;
				break;
			case 1:
				runPoint=110;
				break;
			case 2:
				runPoint=100;
				break;
			case 3:
				runPoint=90;
				break;
			case 4:
				runPoint=80;
				break;
			case 5:
				runPoint=70;
				break;
			case 6:
				runPoint=60;
				break;
			case 7:
				runPoint=50;
				break;
			case 8:
				runPoint=40;
				break;
			case 9:
				runPoint=30;
				break;
			case 10:
				runPoint=-30;
				break;
			case 11:
				runPoint=-40;
				break;
			case 12:
				runPoint=-50;
				break;
			case 13:
				runPoint=-60;
				break;
			case 14:
				runPoint=-70;
				break;
			case 15:
				runPoint=-80;
				break;
			case 16:
				runPoint=-90;
				break;
			case 17:
				runPoint=-100;
				break;
			case 18:
				runPoint=-110;
				break;
			default:
				runPoint=-150;
				break;
		}
		return runPoint;
	}
	/**wicket Point Calculation**/
	public static int CalculateWktPoints(int wktDif){
		int wktPoints=0;
		switch(wktDif){
			case 0:
				wktPoints+=100;
				break;
			case 1:
				wktPoints+=70;
				break;
			case 2:
				wktPoints+=50;
				break;
			case 3:
				wktPoints-=30;
				break;
			default:
				wktPoints-=70;
				break;
		}
		return wktPoints;
	}
}
