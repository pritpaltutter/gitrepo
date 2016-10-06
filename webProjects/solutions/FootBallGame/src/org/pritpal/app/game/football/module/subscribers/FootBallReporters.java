package org.pritpal.app.game.football.module.subscribers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.impl.Team;

/**
 * Reporter class which will contain Overriden publishNews function.
 * This function will be notified once a goal is scored or the Game is over
 * 
 *  @see org.pritpal.app.game.football.module.FootBallGame;
 *
 */
public class FootBallReporters implements Reporter{
	private String reporterName;
	private String reporterCompanyName;
	private Team teamA;
	private Team teamB;

	public FootBallReporters(String reporterName, String reporterCompanyName,Team teamA, Team teamB){
		setReporterName(reporterName);
		setReporterCompanyName(reporterCompanyName);
		setPlayingTeams(teamA,teamB);
	}

	@Override
	public void publishNews(String goalScorerTeamName,FootBallStateEnum gameState) {
		StringBuilder sb = new StringBuilder();
		sb.append(getReporterName()+" reports: ");
		if(gameState.isGameOn()){
			sb.append(goalScorerTeamName);
			sb.append(" has scored a goal at ");
			sb.append(getCurrentTime());
		}else{
			if(getTeamA().getScore()>getTeamB().getScore()){
				sb.append(getTeamA().getTeamName());
				sb.append(" has won the game against ");
				sb.append(getTeamB().getTeamName());
				sb.append(" by "+getTeamA().getScore()+" - "+getTeamB().getScore());
			}else if(getTeamA().getScore()<getTeamB().getScore()){
				sb.append(getTeamB().getTeamName());
				sb.append(" has won the game against ");
				sb.append(getTeamA().getTeamName());
				sb.append(" by "+getTeamB().getScore()+" - "+getTeamA().getScore());
			}else{
				sb.append(" Match is draw ");
				sb.append(getTeamA().getTeamName()+" score: "+getTeamA().getScore());
				sb.append(" ");
				sb.append(getTeamB().getTeamName()+" score: "+getTeamA().getScore());
			}
		}
		sb.append(". Brought to you by ");
		sb.append(reporterCompanyName+" news");
		System.out.println(sb.toString());

	}


	public static String getCurrentTime() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
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

	
	public void setPlayingTeams(Team teamA,Team teamB){
		this.teamA = teamA;
		this.teamB = teamB;
	}
	public Team getTeamA(){
		return teamA;
	}
	public Team getTeamB(){
		return teamB;
	}
}
