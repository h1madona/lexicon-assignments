import java.util.Scanner;

public class Battle {
	private Round round;
	private Player  battleWinner;
	private Scanner scanner = new Scanner(System.in);
	private Player player;
	private Player opponent;

	
	public void startBattle(Player player, Player opponent) {
		this.player = player;
		this.opponent = opponent;
		while(true) {
			
			round = new Round(this.player, this.opponent);
			Player roundWinner = round.fight();
			if(roundWinner != null) {
				roundWinner.addRound(round);
				if(player.getHealth()<=0) {
					battleWinner = opponent;
					System.out.println(opponent.getName()+" has won this battle");
					System.out.println("YOU ARE DEAD ======= GAME OVER");
					break;
				}if(opponent.getHealth()<=0) {
					battleWinner = player;
					System.out.println(player.getName()+" has won this battle");
					System.out.println("-----------");
					System.out.println("you survived!!!!");
					System.out.println("Press Enter to continue with another fighter.");
					scanner.nextLine();
					this.opponent = new Player();
					continue;
				}
					
			}else {
				// no one won the round
			}
			
		}
		
	}
	
	
	
}
