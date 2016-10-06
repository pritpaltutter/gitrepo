package org.pritpal.app.game;

import java.io.IOException;

import org.pritpal.app.game.football.data.GameLoadException;

/**
 *  Main class this will initiate football game 
 *
 */
public class APPMain {


	public static void main(String[] args) {

		PlayGame game = new PlayGame();
		try {
			System.out.println("Initiating Game!!!!");
			game.start();
		} catch (GameLoadException | IOException e) {
			System.out.println("Invalid input entered, terminating game");
		}


	}
}
