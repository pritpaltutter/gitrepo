package org.pritpal.app.game;

import java.io.IOException;

import org.pritpal.app.game.football.FootBallState;
import org.pritpal.app.game.football.StateFactory;
import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.GameLoadException;

/**
 *  This class manages the state of Game
 *  There are three states 
 *  STARTGAME
 *  RUNNING
 *  ENDGAME
 *  
 */
public class PlayGame {
	private FootBallStateEnum state;
	private FootBallState stateRunner;
	private StateFactory stateFactoryInstance;
	private Context gameContext;

	public PlayGame(){
		state = null;
		stateRunner = null;
		gameContext = new Context();
		stateFactoryInstance = StateFactory.getInstance();
	}

	/**
	 * 
	 * @throws GameLoadException
	 * @throws IOException
	 */
	public void start() throws GameLoadException, IOException {

		changeState(FootBallStateEnum.STARTGAME);
		stateRunner = stateFactoryInstance.getState(getState());
		stateRunner.performAction(gameContext);


		changeState(FootBallStateEnum.RUNNING);
		stateRunner = stateFactoryInstance.getState(getState());
		stateRunner.performAction(gameContext);

		changeState(FootBallStateEnum.ENDGAME);
		stateRunner = stateFactoryInstance.getState(getState());
		stateRunner.performAction(gameContext);

	}

	public void changeState(FootBallStateEnum state){
		this.state = state;		
	}

	public FootBallStateEnum getState(){
		return state;
	}


}
