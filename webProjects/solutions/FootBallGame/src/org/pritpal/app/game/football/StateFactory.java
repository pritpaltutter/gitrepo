package org.pritpal.app.game.football;

import org.pritpal.app.game.football.data.FootBallStateEnum;

/**
 * StateFactory is a singleton class which is responsible for creating state objects.
 * Based on the current state this factory will return the state object
 *  
 *
 */
public class StateFactory {
	private StateFactory(){}
	private static class SingletonHolder {
		public  static final StateFactory myInstance = new StateFactory();
	}
	
	public static StateFactory getInstance(){
		return SingletonHolder.myInstance;
	}

	public FootBallState getState(FootBallStateEnum footBallState){
		if(footBallState.isStart()){
			return new StartGame();
		}else if(footBallState.isRunning()){
			return new GameRunning();
		}else {
			return new EndGame();
		}
	}
}
