package com.cts.nfl.vo;

public class MatchPredictVO {

	private boolean toss;
	private boolean winner;
	private int team1Run;
	private int team2Run;
	private int team1Wkt;
	private int team2Wkt;
	private int matchNo;
	public int getMatchNo() {
		return matchNo;
	}
	public void setMatchNo(int matchNo) {
		this.matchNo = matchNo;
	}
	public boolean isToss() {
		return toss;
	}
	public void setToss(boolean toss) {
		this.toss = toss;
	}
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	public int getTeam1Run() {
		return team1Run;
	}
	public void setTeam1Run(int team1Run) {
		this.team1Run = team1Run;
	}
	public int getTeam2Run() {
		return team2Run;
	}
	public void setTeam2Run(int team2Run) {
		this.team2Run = team2Run;
	}
	public int getTeam1Wkt() {
		return team1Wkt;
	}
	public void setTeam1Wkt(int team1Wkt) {
		this.team1Wkt = team1Wkt;
	}
	public int getTeam2Wkt() {
		return team2Wkt;
	}
	public void setTeam2Wkt(int team2Wkt) {
		this.team2Wkt = team2Wkt;
	}
	
	
}
