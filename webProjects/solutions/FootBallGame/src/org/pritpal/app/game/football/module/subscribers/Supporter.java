package org.pritpal.app.game.football.module.subscribers;

import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.TeamEnum;

/**
 * Supporter interface for actions to be performed by an reporter once notified 
 */
public interface Supporter {
	
	public void performAction(TeamEnum goalScorerTeam,FootBallStateEnum gameState);
}
