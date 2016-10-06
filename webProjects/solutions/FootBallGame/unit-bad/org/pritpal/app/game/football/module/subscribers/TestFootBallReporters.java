package org.pritpal.app.game.football.module.subscribers;

import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.impl.Team;

public class TestFootBallReporters implements Reporter{
	private String reporterName;
	private String reporterCompanyName;
	private Team teamA;
	private Team teamB;
	public  Boolean reporterNotified =  Boolean.FALSE;
	
	public TestFootBallReporters(String reporterName, String reporterCompanyName,Team teamA, Team teamB){
		setReporterName(reporterName);
		setReporterCompanyName(reporterCompanyName);
		setTeamA(teamA);
		setTeamB(teamB);
	}

	@Override
	public void publishNews(String goalScorerTeamName, FootBallStateEnum gameState) {
		reporterNotified = Boolean.TRUE;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public String getReporterCompanyName() {
		return reporterCompanyName;
	}

	public void setReporterCompanyName(String reporterCompanyName) {
		this.reporterCompanyName = reporterCompanyName;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

}
