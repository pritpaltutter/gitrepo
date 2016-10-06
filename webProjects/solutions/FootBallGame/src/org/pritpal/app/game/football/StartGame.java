package org.pritpal.app.game.football;

import java.io.IOException;
import org.pritpal.app.game.Context;
import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.GameLoadException;
import org.pritpal.app.game.football.data.TeamEnum;
import org.pritpal.app.game.football.data.impl.FootBallTeam;
import org.pritpal.app.game.football.data.impl.Team;
import org.pritpal.app.game.football.module.subscribers.FootBallReporters;
import org.pritpal.app.game.football.module.subscribers.FootBallSupporters;

/**
 *  This state is responsible for reading the input from console and 
 *   handling the initialization of supporters and reporters and will register with FootBallGame
 *  
 *   Console input should be entered in sequence other wise it will lead to unusual Game behaviour
 *
 */
public class StartGame implements FootBallState{

	@Override
	public void performAction(Context footBallContext) throws GameLoadException {
		footBallContext.getGame().updateState(FootBallStateEnum.STARTGAME);
		showHelpMessage();
		try{
			readParseConsole(footBallContext);
		}catch(StringIndexOutOfBoundsException ex){
			throw new GameLoadException("Invalid input entered");
		}catch(NumberFormatException nfe){
			throw new GameLoadException("Invalid input entered");
		}
	}
	/**
	 * Reads console input commands only for Start Game state
	 * 
	 * @param footBallContext
	 * @throws GameLoadException
	 */
	private void readParseConsole(Context footBallContext) throws  GameLoadException{

		String commandName = null;;
		System.out.println("Enter Game Start Command : ");
		try {
			do{
				if(commandName != null){
					System.out.println("Invalid Command Name, enter correct start command name");
				}
				commandName = footBallContext.getBufferReader().readLine();
			}while(!(commandName.equalsIgnoreCase("StartGame") || commandName.equalsIgnoreCase("Start Game")||
					commandName.equalsIgnoreCase("Game Start") || commandName.equalsIgnoreCase("GameStart")));
		} catch (IOException e) {
			throw new GameLoadException("Error reading from console");
		}
		// Get Team Names
		System.out.println("Enter Team Names without space seperated by ':' ");
		try {
			commandName = footBallContext.getBufferReader().readLine();
		} catch (IOException e1) {
			throw new GameLoadException("Error reading from console");
		}
		String teamA_Name = commandName.trim().substring(0, commandName.indexOf(":"));
		String teamB_Name = commandName.trim().substring(commandName.indexOf(":")+1, commandName.length());

		Team teamA = new FootBallTeam(teamA_Name, TeamEnum.TeamA);
		Team teamB = new FootBallTeam(teamB_Name, TeamEnum.TeamB);
		footBallContext.getGame().registerTeam(teamA, teamB);

		// Get supporters and reporters count
		System.out.println("Enter supporters and reporters count");
		try {
			commandName = footBallContext.getBufferReader().readLine();
		} catch (IOException e) {
			throw new GameLoadException("Error reading from console");
		}
		int supportersCount = Integer.parseInt(commandName.trim().substring(0, commandName.indexOf(":")));
		int reportersCount = Integer.parseInt(commandName.trim().substring(commandName.indexOf(":")+1, commandName.length()));

		for(int i=0;i<supportersCount;i++){
			System.out.println("Enter supporter name and supporting team");
			try {
				commandName = footBallContext.getBufferReader().readLine();
			} catch (IOException e) {
				throw new GameLoadException("Error reading from console");
			}
			String supporterName = commandName.trim().substring(0, commandName.indexOf(":"));
			String supportingTeamName = commandName.trim().substring(commandName.indexOf(":")+1, commandName.length());
			if(supportingTeamName.equals(teamA.getTeamName())){
				footBallContext.getGame().registerSupporter(new FootBallSupporters(supporterName,teamA));
			}else{
				footBallContext.getGame().registerSupporter(new FootBallSupporters(supporterName,teamB));
			}
		}
		for(int i=0;i<reportersCount;i++){
			System.out.println("Enter reporter name and company name");
			try {
				commandName = footBallContext.getBufferReader().readLine();
			} catch (IOException e) {
				throw new GameLoadException("Error reading from console");
			}
			String reporterName = commandName.trim().substring(0, commandName.indexOf(":"));
			String reporterCompanyName = commandName.trim().substring(commandName.indexOf(":")+1, commandName.length());
			footBallContext.getGame().registerReporter(new FootBallReporters(reporterName,reporterCompanyName,teamA,teamB));
		}
	}

	/**
	 * Help message for Entering input through console
	 */
	public void showHelpMessage(){
		StringBuilder sb = new StringBuilder();
		sb.append("Follow below command names for entering instructions\n");
		sb.append("-----------------------------------------------------------------------------------------------------------\n");

		sb.append(" Command Name                | 	Action				  		   \n");
		sb.append("-----------------------------------------------------------------------------------------------------------\n");
		sb.append(" Game Start                  |	 Start football game			   \n");
		sb.append(" Team1Name:Team2Name         |	 Enter Team1 and Team2 without space and ':' in between\n");
		sb.append(" #supporters:#reporters      |   Enter number of supporters and reporters without space and : in between\n");
		sb.append(" supporterName:#TeamName     |   Enter supporter name and team it supports and : in between\n");
		sb.append(" supporterName:#TeamName     |   Enter supporter name and team it supports and : in between\n");
		sb.append(" reporterName:#TeamName      |   Enter reporter name and company it works and : in between\n");
		sb.append(" Goal:TeamName               |	 Register goal for the Team mentioned\n");
		sb.append(" Game over                   |	 Game over\n");
		sb.append("-----------------------------------------------------------------------------------------------------------\n");
		System.out.print(sb.toString());

	}

}
