package org.pritpal.app.game.football.module;
import java.util.ArrayList;
import java.util.List;
import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.GameDrawException;
import org.pritpal.app.game.football.data.TeamEnum;
import org.pritpal.app.game.football.data.impl.Team;
import org.pritpal.app.game.football.module.subscribers.Reporter;
import org.pritpal.app.game.football.module.subscribers.Supporter;


/**
 * FootBallGame class will be the main class which will be run the FootBall game.
 * This will contain
 * Team playing, State of the game i.e. Start, Running, End.
 * Supporters list and reporters list 
 * Once a goal is scored this will notify all the supporters and reporters which has subscribed to this game.
 * 
 */
public class FootBallGame implements Game{

	private Team teamA;
	private Team teamB;
	private TeamEnum lastGoalTeamName;
	private FootBallStateEnum footBallGameState;
	private List<Supporter> supporters; 
	private List<Reporter> reporters;

	public FootBallGame(){
		supporters = new ArrayList<Supporter>();
		reporters = new ArrayList<Reporter>();
	}

	/**
	 * When ever a team hits a goal, team goal count is increased  
	 */
	public void addGoal() {
		Team scorrerTeam = getScorerTeam();
		scorrerTeam.addGoal();
		// notify all subscribers
		notifyScore(scorrerTeam.getTeamName(),scorrerTeam.getTeamType(),getGameState());

	}

	@Override
	public void calculateResult() {
		Team winningTeam = null;
		try {
			winningTeam = getWinningTeamName();
			// notify all subscribers
			notifyScore(winningTeam.getTeamName(),winningTeam.getTeamType(),getGameState());

		} catch (GameDrawException e) {
			notifyScore(null,null,getGameState());
		}
	}
	@Override
	public void notifyScore(String goalScorerTeamName,TeamEnum teamGroup,FootBallStateEnum gameState) {
		for(Supporter supporter:supporters){
			supporter.performAction(teamGroup,gameState);
		}
		for(Reporter reporter:reporters){
			reporter.publishNews(goalScorerTeamName,gameState);
		}

	}

	private Team getScorerTeam(){
		if(getLastGoalTeam() == getTeamA().getTeamType()){
			return getTeamA();
		}else{
			return getTeamB();
		}
	}

	private Team getWinningTeamName() throws GameDrawException{
		if(getTeamA().getScore() > getTeamB().getScore()){
			return getTeamA();
		}else if(getTeamA().getScore() < getTeamB().getScore()){
			return getTeamB();
		}else{
			throw new GameDrawException("Scores are equal");
		}
	}
	@Override
	public void updateState(FootBallStateEnum newState) {
		setState(newState);
	}

	@Override
	public void registerTeam(Team team_A, Team team_B) {
		this.teamA = team_A;
		this.teamB = team_B;

	}

	@Override
	public void registerSupporter(Supporter suppporter) {
		supporters.add(suppporter);

	}
	@Override
	public void unRegisterSupporter() {
		supporters.clear();


	}
	@Override
	public void registerReporter(Reporter reporter) {
		reporters.add(reporter);
	}

	@Override
	public void unRegisterReporter() {
		reporters.clear();

	}

	@Override
	public Team getTeamA(){
		return teamA;
	}
	@Override
	public Team getTeamB(){
		return teamB;
	}

	@Override
	public void setLastGoalTeam(TeamEnum teamName){
		this.lastGoalTeamName = teamName;
	}

	public TeamEnum getLastGoalTeam(){
		return lastGoalTeamName;
	}


	public String getTotalScore() {
		return teamA+" -- "+teamB;
	}
	public void setState(FootBallStateEnum newState){
		this.footBallGameState = newState;
	}
	public FootBallStateEnum getGameState(){
		return footBallGameState ;
	}



}
