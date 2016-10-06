package org.pritpal.app.game.football.module.subscribers;

import org.pritpal.app.game.football.data.FootBallStateEnum;
import org.pritpal.app.game.football.data.TeamEnum;
import org.pritpal.app.game.football.data.impl.Team;

public class TestFootBallSupporters implements Supporter{
	private Team supportingTeam;
	private String supporterName;
	public Boolean supporterNotified =  Boolean.FALSE;

	public TestFootBallSupporters(String supporterName,Team supportingTeam){
		setSupporterName(supporterName);
		setSupportingTeam(supportingTeam);
	}
	@Override
	public void performAction(TeamEnum goalScorerTeam, FootBallStateEnum gameState) {
		supporterNotified = Boolean.TRUE;
		
	}
	public Team getSupportingTeam() {
		return supportingTeam;
	}
	public void setSupportingTeam(Team supportingTeam) {
		this.supportingTeam = supportingTeam;
	}
	public String getSupporterName() {
		return supporterName;
	}
	public void setSupporterName(String supporterName) {
		this.supporterName = supporterName;
	}

}
