package models;

public class Ball {
	//set the initial distance from the cup.
	private double distanceFromCup = 750;

	public double getDistanceFromCup() {
		return distanceFromCup;
	}

	public void setDistanceFromCup(double distanceFromCup) {
		this.distanceFromCup = distanceFromCup;
	}
	
	//each swing will change the distance from cup based on it's strength.
	public void swing(Swing newSwing) {
		distanceFromCup = (Math.abs(distanceFromCup - newSwing.getPassedDistance()));
	}

}
