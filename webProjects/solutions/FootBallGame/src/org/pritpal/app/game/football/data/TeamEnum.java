package org.pritpal.app.game.football.data;

/**
 * Enum for team groups.
 * The Game will be between 2 teams and one team will be TeamA and another in TeamB
 * This is used by supporters to categorize the supporting team 
 *
 */
public enum TeamEnum {

	TeamA("TeamA"),
	TeamB("TeamB");
	String team;
	TeamEnum(String team){
		this.team = team;
	}
	public String getType(){
		return team;
	}
}
