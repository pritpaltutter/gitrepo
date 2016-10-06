package org.pritpal.app.game.football.module;

import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.TeamEnum;
import org.pritpal.app.game.football.data.impl.Team;
import org.pritpal.app.game.football.module.subscribers.Reporter;
import org.pritpal.app.game.football.module.subscribers.Supporter;

/**
 * Game interface will contain functionality general for all 
 * games and since it is an FootBall game it will extend the functionality from FootBall game interface  
 *
 */
public interface Game extends FootBallInterface{
	
	public void registerTeam(Team teamA, Team teamB);
	
	public void registerSupporter(Supporter supporter);
	
	public void unRegisterSupporter();
	
	public void registerReporter(Reporter reporter);
	
	public void unRegisterReporter();
	
	void notifyScore(String goalScorerTeamName,TeamEnum teamGroup,FootBallStateEnum gameState);
}
