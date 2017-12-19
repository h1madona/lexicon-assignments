package models;

public class Swing {

	// constants representing angle and velocity limits.
	public static final int MAX_ANGLE = 90;
	public static final int MAX_VELOCITY = 95;

	// a constant representing gravity that will be used to calculate distance.
	private static final double GRAVITY = 9.8;

	// angle and velocity should be set by user and then used to calculate distance.
	private double angle;
	private double velocity;

	public Swing(int angle, int velocity) {

		// converting angle to radian to be able to calculate distance.
		this.angle = (Math.PI / 180) * angle;
		this.velocity = velocity;
	}

	// calculate the distance the ball can travel, based on the angle and velocity.
	public double getPassedDistance() {
		return Math.pow(velocity, 2) / GRAVITY * Math.sin(2 * angle);
	}

}
