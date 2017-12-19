import java.util.Arrays;
import java.util.Random;

public class Player {
	private int strength;
	private int health;
	private int damage;
	private String name;
	private Random random = new Random();
	private Round[] rounds;
	private Battle[] battles;
	private String[] names = {"DRAGON FEST", "IRON FART", "BLACK ANGEL", "WHITE WIDOW"};
	
	public Player(String name) {
		this();
		this.setName(name);
	}
	
	public Player() {
		this.setName(names[random.nextInt(4)]);
		this.setStrength(random.nextInt(5)+6);
		this.setHealth(random.nextInt(5)+6);
		this.setDamage(this.strength/2);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if(health<0) {
			health = 0;
		}
		this.health = health;
	}

	public Round[] getRounds() {
		return rounds;
	}

	public void addRound(Round round) {
		rounds = new Round[1];
		if(rounds[rounds.length-1]!= null) {
			Arrays.copyOf(rounds, rounds.length+1);
		}
		rounds[rounds.length-1] = round;
	}
	public void addBattle(Battle battle) {
		battles = new Battle[1];
		if(battles[battles.length-1]!= null) {
			Arrays.copyOf(battles, battles.length+1);
		}
		battles[battles.length-1] = battle;
	}
	public Battle[] getBattles() {
		return battles;
	}
}
