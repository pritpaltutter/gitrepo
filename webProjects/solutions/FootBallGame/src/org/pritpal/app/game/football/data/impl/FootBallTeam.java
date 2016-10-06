package org.pritpal.app.game.football.data.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.pritpal.app.game.football.data.GameEnum;
import org.pritpal.app.game.football.data.TeamEnum;

/**
 * FootBall team class containing team details, like 
 * TeamName, playerList, read write lock for preventing totals update and read synchronization  
 *
 */
public class FootBallTeam implements Team{

	private String teamName;
	private TeamEnum teamType;
	private List<Player> playersList ;
	private int score;
	final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	final ReadLock readLock = rwl.readLock();
	final WriteLock writeLock = rwl.writeLock();


	public FootBallTeam(String teamName,TeamEnum teamType){
		playersList = new ArrayList<Player>();
		setTeamType(teamType);
		this.teamName = teamName;
		createDummyPlayerList();
	}

	@Override
	public String getTeamName() {
		return teamName;
	}

	@Override
	public List<Player> getPlayers() {
		return playersList;
	}

	@Override
	public String getGameName() {
		return GameEnum.FOOTBALL.getName();
	}

	public void createDummyPlayerList(){
		List<String> dummyList = new ArrayList<String>();
		dummyList.add("Player1");
		dummyList.add("Player2");
		dummyList.add("Player3");
		dummyList.add("Player4");
		dummyList.add("Player5");
		dummyList.add("Player6");
		setPlayersName(dummyList);
	}
	/**
	 * Iterates through the playerNames list and create a list of IPlayer type
	 */
	public void setPlayersName(List<String> playerNames){
		for(String name:playerNames){
			playersList.add(new FootBallPlayer(name));
		}
	}
	@Override
	public void addGoal() {
		writeLock.lock();
		try{
			this.score++;
		}finally{
			writeLock.unlock();
		}
	}
	@Override
	public int getScore() {
		readLock.lock();
		try{
			return this.score;
		}finally{
			readLock.unlock();
		}
	}
	@Override
	public String toString(){
		return getTeamName()+":"+getScore();
	}

	public TeamEnum getTeamType() {
		return teamType;
	}

	public void setTeamType(TeamEnum teamType) {
		this.teamType = teamType;
	}
}
