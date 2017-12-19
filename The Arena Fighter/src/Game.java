import java.util.Scanner;

public class Game {
	private static Scanner scanner;
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		System.out.print("Please Enter your name: ");
		String name;
		//validate name length.
		while(true) {
			name = scanner.nextLine();
			if(name.length()>1 && name.length()<50) {
				break;
			}
			System.out.println("the name is too short, try again..");
			continue;
		}
		System.out.println("Welcome to the Arena "+ name+"\n");
		Player player = new Player(name);
		Player opponent = new Player();
		System.out.println(player.getName()+"\t\t VS\t\t"+opponent.getName());
		new Battle().startBattle(player, opponent);
		

		
	}
}
