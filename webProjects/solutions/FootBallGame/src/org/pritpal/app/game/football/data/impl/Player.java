package org.pritpal.app.game.football.data.impl;

/**
 * Player defines player interface.
 * Players of different games can implement this Interface 
 */
public interface Player {

	/**
	 * Game which player plays
	 */
	public String playerGameName();
	
	/**
	 * Field in which player is good 
	 */
	public void definePlayerStrength();
}
