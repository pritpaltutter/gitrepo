package org.pritpal.app.game.football.module;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.pritpal.app.game.football.data.TeamEnum;
import org.pritpal.app.game.football.data.impl.FootBallTeam;
import org.pritpal.app.game.football.data.impl.Team;
import org.pritpal.app.game.football.module.subscribers.TestFootBallReporters;
import org.pritpal.app.game.football.module.subscribers.TestFootBallSupporters;

public class TestFootBallGame {


	@Test
	public void test() {
		Game game = new FootBallGame();
		Team testTeamA = new FootBallTeam("TestTeamA", TeamEnum.TeamA);
		Team testTeamB = new FootBallTeam("TestTeamB", TeamEnum.TeamB);
		TestFootBallReporters reporter = new TestFootBallReporters("Test", "Test", testTeamA, testTeamA);
		TestFootBallSupporters supporter = new TestFootBallSupporters("TestSupporter", testTeamA);
		game.registerTeam(testTeamA, testTeamB);
		game.registerReporter(reporter);
		game.registerSupporter(supporter);
		game.setLastGoalTeam(TeamEnum.TeamA);
		game.addGoal();
		if(reporter.reporterNotified){
			assertTrue("Reporter is notified", Boolean.TRUE);
		}else{
			fail("Supporter is not notified");
		}
		if(supporter.supporterNotified){
			assertTrue("supporter is notified", Boolean.TRUE);
		}else{
			fail("Supporter is not notified");
		}
	}





}
