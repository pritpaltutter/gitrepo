package org.pritpal.app.game.football.module;

import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.TeamEnum;
import org.pritpal.app.game.football.data.impl.Team;

/**
 * FootBall interface will contain football specific functionality.  
 *
 */
public interface FootBallInterface {
	
	public void addGoal();
	
	public void updateState(FootBallStateEnum gameState);
	
	public void calculateResult();
	
	public Team getTeamA();
	
	public Team getTeamB();
	
	public void setLastGoalTeam(TeamEnum teamName);
	
	
	
}
