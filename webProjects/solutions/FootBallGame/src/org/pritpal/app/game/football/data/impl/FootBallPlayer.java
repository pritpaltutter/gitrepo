package org.pritpal.app.game.football.data.impl;
import org.pritpal.app.game.football.data.GameEnum;

/**
 *  Bean class for FootBall player
 */
public class FootBallPlayer implements Player{

	private String playerName;
	FootBallPlayer(String playerName){
		setPlayerName(playerName);
	}
	@Override
	public String playerGameName() {
		return GameEnum.FOOTBALL.getName();
	}

	/**
	 * This API will define the player strength which can be 
	 * implemented in future
	 */
	@Override
	public void definePlayerStrength() {
		/**
		 ** Define player strength
		 **/
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}



}
