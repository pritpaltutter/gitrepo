package org.pritpal.app.game.football.module.subscribers;

import org.pritpal.app.game.football.data.FootBallStateEnum;

/**
 * Reporter interface for actions to be performed by an reporter once notified 
 *
 */
public interface Reporter {
	
	public void publishNews(String goalScorerTeamName,FootBallStateEnum gameState);
}
