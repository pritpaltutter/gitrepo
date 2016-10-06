package org.pritpal.app.game.football;

import org.pritpal.app.game.Context;
import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.module.Game;

/**
 * This state is responsible for unregistering the supporters and reporters and closing the streams 
 *
 */
public class EndGame implements FootBallState{

	@Override
	public void performAction(Context footBallContext) {
		footBallContext.getGame().updateState(FootBallStateEnum.ENDGAME);
		footBallContext.closeStream();
		Game game = footBallContext.getGame();
		game.calculateResult();
		game.unRegisterSupporter();
		game.unRegisterReporter();
	}

}
