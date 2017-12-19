import java.util.Scanner;

public class Round {
	private Player player;
	private Player opponent;
	private Player roundWinner;
	private Scanner scanner;
	
	public Round(Player player, Player opponent) {
		this.player = player;
		this.opponent = opponent;
		scanner = new Scanner(System.in);
	}
	
	public Player fight() {
		while(true) {
			
			if(player.getStrength()>opponent.getStrength()) {
				//player strikes first.
				opponent.setHealth(opponent.getHealth()-player.getDamage());
				System.out.println(player.getName()+" strikes..");
				System.out.println("damage caused to "+opponent.getName()+" is "+ player.getDamage());
				System.out.println(opponent.getName()+" health is: "+opponent.getHealth());
				roundWinner = player;
				break;
				
				
			}if(opponent.getStrength()>player.getStrength()) {
				//opponent strikes first.
				player.setHealth(player.getHealth()-opponent.getDamage());
				System.out.println(opponent.getName()+" strikes..");
				System.out.println("damage caused to "+player.getName()+" is "+ opponent.getDamage());
				System.out.println(player.getName()+" health is: "+player.getHealth());
				roundWinner = opponent;
				break;
				
			}if(player.getStrength() == opponent.getStrength()) {
				if(player.getHealth()>opponent.getHealth()) {
					player.setStrength(player.getStrength()+1);
				}else {
					player.setStrength(player.getStrength()-1);
				}
			}
			
			
		}
		return roundWinner;
		
		
		
	}
	
	
}
