package org.pritpal.app.game.football;

import java.io.IOException;

import org.pritpal.app.game.Context;
import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.GameLoadException;
import org.pritpal.app.game.football.module.Game;

/**
 * Game running state
 * This state is responsible to accepting inputs from console and performing actions
 * Expected input/command from console 
 * Goal:TeamName --> This command will add goal to the team specified
 * Game Over --> This command will finish the game and game state will be changed to EndGame
 * 
 *
 */
public class GameRunning implements FootBallState{

	@Override
	public void performAction(Context footBallContext) throws GameLoadException {
		Game footBallGame = footBallContext.getGame();
		footBallGame.updateState(FootBallStateEnum.RUNNING);
		while(true){
			System.out.println("Enter Goal:Team Name without space");
			String commandName = getConsoleInput(footBallContext);
			if(!(commandName.equalsIgnoreCase("Game over")||commandName.equalsIgnoreCase("Gameover"))){
				String command = commandName.trim().substring(0, commandName.indexOf(":"));
				String teamName = commandName.trim().substring(commandName.indexOf(":")+1, commandName.length());
				if(command.equals("Goal")){
					if(footBallContext.getGame().getTeamA().getTeamName().equals(teamName)){
						footBallGame.setLastGoalTeam(footBallContext.getGame().getTeamA().getTeamType());
					}else{
						footBallGame.setLastGoalTeam(footBallContext.getGame().getTeamB().getTeamType());
					}
					footBallGame.addGoal();
				}
			}else{
				System.out.println("Game Over...!!!");
				break;
			}
		}
	}

	/**
	 * Get console Input 
	 * 
	 * @param footBallContext
	 * @return
	 * @throws GameLoadException
	 */
	public String getConsoleInput(Context footBallContext) throws GameLoadException{

		String commandName;
		try {
			commandName = footBallContext.getBufferReader().readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new GameLoadException("Error reading from console");
		}
		return commandName;

	}
}
