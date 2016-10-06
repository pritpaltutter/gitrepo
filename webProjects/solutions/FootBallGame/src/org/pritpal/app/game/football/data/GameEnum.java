package org.pritpal.app.game.football.data;

/**
 * Enum containing game Name 
 *
 */
public enum GameEnum {

	FOOTBALL("FOOTBALL");
	String name;
	GameEnum(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
