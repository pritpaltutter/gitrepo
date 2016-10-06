package org.pritpal.app.game.football.data;

/**
 * This exception is created to handle the exceptional scenario 
 * in which the game is ended in a draw. 
 *
 */
public class GameDrawException extends Exception{

	public GameDrawException(){
		super();
	}
	public GameDrawException(String errorMessage){
		super(errorMessage);
	}
}