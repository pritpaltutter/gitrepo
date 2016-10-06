package org.pritpal.app.game.football.data;

/**
 * Custom exception for handling Games operations  
 *
 */
public class GameLoadException extends Exception{
	
	public GameLoadException(){
		super();
	}
	public GameLoadException(String errorMessage){
		super(errorMessage);
	}
}
