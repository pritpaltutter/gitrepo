package org.pritpal.app.game.football.data.impl;

import java.util.List;
import org.pritpal.app.game.football.data.TeamEnum;
/**
 * Interface to define Team activity
 */
public interface Team {

	public String getTeamName();
	
	public TeamEnum getTeamType();
	
	public List<Player> getPlayers();
	
	public String getGameName();
	
	public void addGoal();
	
	public int getScore();
}
