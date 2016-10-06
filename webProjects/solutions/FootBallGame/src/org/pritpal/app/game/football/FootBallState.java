package org.pritpal.app.game.football;

import org.pritpal.app.game.Context;
import org.pritpal.app.game.football.data.GameLoadException;

/**
 * FootBall state interface 
 * Implementing class will write performAction 
 * function to perform specific task related to its state 
 *
 */
public interface FootBallState {
	
	public void performAction(Context footBallContext) throws GameLoadException;
}
