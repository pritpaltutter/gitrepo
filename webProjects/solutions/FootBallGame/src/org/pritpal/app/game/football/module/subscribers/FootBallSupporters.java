package org.pritpal.app.game.football.module.subscribers;

import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.TeamEnum;
import org.pritpal.app.game.football.data.impl.Team;

/**
 * Supporter class containing Overriden performAction function 
 * responsible for performing action once it is notified.
 * 
 * @see org.pritpal.app.game.football.module.FootBallGame;
 */
public class FootBallSupporters implements Supporter{

	private Team supportingTeam;
	private String supporterName;
	

	public FootBallSupporters(String supporterName,Team supportingTeam){
		setSupporterName(supporterName);
		setSupportingTeam(supportingTeam);
	}

	@Override
	public void performAction(TeamEnum goalHittingTeam,FootBallStateEnum gameState) {
		if(gameState.isGameOn()){
			if(goalHittingTeam == getSupportingTeam().getTeamType()){
				System.out.println(getSupporterName()+" says: Hurray!!!");
			}else{
				System.out.println(getSupporterName()+" says: Alas!!!");
			}
		}else{
			if(goalHittingTeam!=null){
				if(goalHittingTeam == getSupportingTeam().getTeamType()){
					System.out.println(getSupporterName()+" says Yes!"+getSupportingTeam().getTeamName()+" Won Hurray!!!");
				}else{
					System.out.println(getSupporterName()+" says: Alas!!!"+getSupportingTeam().getTeamName()+" Lost!!!");
				}
			}else{
				// Game is draw
				System.out.println(getSupporterName()+" says: The Game was Good!!!");
			}
		}
	}
	public String getSupporterName() {
		return supporterName;
	}

	public void setSupporterName(String supporterName) {
		this.supporterName = supporterName;
	}
	public Team getSupportingTeam() {
		return supportingTeam;
	}

	public void setSupportingTeam(Team supportingTeam) {
		this.supportingTeam = supportingTeam;
	}

}
