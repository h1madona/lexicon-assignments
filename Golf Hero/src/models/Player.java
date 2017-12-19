package models;

import java.util.ArrayList;
import java.util.List;

import utilities.Utils;

public class Player {

	// a list to save the Swings the player will make during the game.
	private ArrayList<Swing> swings;

	public Player() {
		swings = new ArrayList<>();
	}

	// add the given Swing object to the list.
	public void addSwing(Swing swing) {
		swings.add(swing);
	}

	// return the swings the player has done so far.
	public ArrayList<Swing> getSwings() {
		return swings;
	}

	// print informations about each swing the player has played.
	public void displaySwings() {
		Utils.print("Your Swings Details Are: \n");
		for (int i = 0; i < swings.size(); i++) {

			// format the passedDistance to display it to user with less digits after the
			// comma.
			String formattedPassedDistance = Utils.formatDouble(swings.get(i).getPassedDistance());
			Utils.print("Swing " + (i + 1) + ": distance: " + formattedPassedDistance + " m");
		}
	}
}
