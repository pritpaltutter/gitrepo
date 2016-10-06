package org.pritpal.app.game.football.data;

/**
 * Enum for storing multiple states of a Game.
 *
 */
public enum FootBallStateEnum {

	STARTGAME("Start Game"),
	RUNNING("Running"),
	ENDGAME("Game Over");
	String state;
	FootBallStateEnum(String state){
		this.state = state;
	}
	public String getState(){
		return state;
	}
	public Boolean isStart(){
		if(state.equals("Start Game")){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	public Boolean isRunning(){
		if(state.equals("Running")){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	public Boolean isEnd(){
		if(state.equals("Game Over")){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	public Boolean isGameOn(){
		if(!state.equals("Game Over")){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
}
