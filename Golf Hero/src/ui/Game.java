package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import models.Ball;
import models.Player;
import models.Swing;
import utilities.Utils;

public class Game {
	private Player player;
	private Ball ball;
	private Scanner scanner;

	// tolerance will represent the game difficulty, which will be set by user.
	private int tolerance;

	public Game(Player player, Ball ball) {
		this.player = player;
		this.ball = ball;
		scanner = new Scanner(System.in);
	}

	// start the game.
	public void start() {
		Utils.print("Welcome To Golf Hero.");
		/*
		 * let user choose difficulty from 1 to 5, these numbers will reflect the
		 * tolerance of the cup area the less tolerance, the easiest.
		 */
		Utils.print("Choose Difficulty: 1 to 5 (Hardest is 5)");
		int difficulty = getInputNumber(5);
		assignDifficulty(difficulty);

		Utils.print("Let's start kicking the ball!!");
		Utils.print("choose an angle and a velocity for each swing");
		Utils.print("_____________________________________________");

		/*
		 * keep looping until the ball reaches the hole, or until the player tries too
		 * many times.
		 */
		while (true) {

			// get values from user.
			Utils.print("enter angle:");
			int angle = getInputNumber(Swing.MAX_ANGLE);
			Utils.print("enter velocity: ");
			int velocity = getInputNumber(Swing.MAX_VELOCITY);

			// do the swing with the given angle and velocity.
			Swing swing = new Swing(angle, velocity);
			player.addSwing(swing);
			ball.swing(swing);

			// calculate distance passed after the swing, and print details to the user.
			double distancePassed = swing.getPassedDistance();
			Utils.print("Distance Passed : " + Utils.formatDouble(distancePassed));

			// calculate distance from the cup and display to the user.
			double distanceFromCup = ball.getDistanceFromCup();
			Utils.print("Distance From Cup : " + Utils.formatDouble(distanceFromCup));
			Utils.print("---------------");

			/*
			 * check if the ball reached the hole, or if the player tried too many times, if
			 * none of this happens, keep swinging...
			 */
			if (Math.abs(distanceFromCup) <= this.tolerance) {
				Utils.print("Winner!!!!");
				Utils.print("You Have Reached The Goal Only In " + player.getSwings().size() + " Swings!!");
				player.displaySwings();
				break;
			} else if (player.getSwings().size() >= 10) {
				Utils.print("Game Over.. Too Many Swings..");
				player.displaySwings();
				break;
			} else {
				Utils.print("Keep Swinging...");
			}

		}
	}

	// get an input from user as int.
	private int getInputNumber(int limit) {
		while (true) {
			try {
				int input = scanner.nextInt();

				// make sure the input is in range.
				if (input > 0 && input <= limit)
					return input;
				else
					Utils.print("Please Enter A Number between 1 and " + limit);
			} catch (InputMismatchException e) {
				Utils.print("ONLY NUMBERS ALLOWED HERE!!");
				continue;
			} finally {
				scanner.nextLine();
			}
		}

	}

	// this method will assign values to the cup area tolerance, based on the given
	// difficulty number.
	private void assignDifficulty(int difficulty) {
		switch (difficulty) {
		case 1:
			this.tolerance = 25;
			break;
		case 2:
			this.tolerance = 15;
			break;
		case 3:
			this.tolerance = 10;
			break;
		case 4:
			this.tolerance = 5;
			break;
		case 5:
			this.tolerance = 1;
			break;
		default:
			this.tolerance = 15;
			break;
		}
	}

}
