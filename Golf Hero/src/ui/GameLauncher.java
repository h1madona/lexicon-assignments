package ui;

import models.Ball;
import models.Player;

public class GameLauncher {
	public static void main(String[] args) {
		// create a player, and a ball to start the game.
		Player player = new Player();
		Ball ball = new Ball();
		Game game = new Game(player, ball);
		game.start();
	}
}
