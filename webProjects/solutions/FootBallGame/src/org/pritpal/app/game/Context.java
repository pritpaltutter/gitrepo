package org.pritpal.app.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.pritpal.app.game.football.module.FootBallGame;
import org.pritpal.app.game.football.module.Game;

public class Context {
	private Game game ;
	private BufferedReader bufferReader = null;

	public Context(){
		setGame(new FootBallGame());
		initStream();
	}

	private void initStream(){

		bufferReader = new BufferedReader(new InputStreamReader(System.in));

	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public BufferedReader getBufferReader() throws IOException {
		if(bufferReader.ready()){
			return bufferReader;
		}else{
			initStream();
			return bufferReader;
		}
	}

	public void setBufferReader(BufferedReader bufferReader) {
		this.bufferReader = bufferReader;
	}

	public void closeStream(){

		if (bufferReader != null) {
			try {
				bufferReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
