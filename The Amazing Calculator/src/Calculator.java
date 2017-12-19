import java.util.Scanner;

public class Calculator {
	private static double fNum;
	private static double sNum;
	private static String operator;
	private static Scanner scanner;
	private static Processor processor;
	
	public static void main(String[] args) {
		
	
		//Initializing the Scanner.
		scanner = new Scanner(System.in);
			
		//looping to get data from user.
		while(true) {
			//getting first number from user.
			System.out.print("Enter first number please: ");
			String inputStr = scanner.nextLine();
			try {
				fNum = Double.parseDouble(inputStr);
			}catch(NumberFormatException e){
				System.out.println("NOT A NUMBER!!!");
				continue;
			}
			
			//getting operation from user.
			System.out.print("Which operation do you want to perform? (+, -, *, /) ");
			operator = scanner.nextLine();
			
			//handling the operator.
			if(!isOperator(operator)) {
				System.out.println("NOT AN OPERATOR!!!!!");
				continue;
			}
			
			
			//displaying what we have so far.
			System.out.println(fNum+" "+operator+" ");
			
			//getting second number from user.
			System.out.println("Enter second number please: ");
			inputStr = scanner.nextLine();
			try {
				sNum = Double.parseDouble(inputStr);
			}catch(NumberFormatException e){
				System.out.println("NOT A NUMBER!!!");
				continue;
			}
			
			//Initializing the Processor.
			processor = new Processor(fNum, sNum, operator);
			
			String output = processor.process();
			System.out.println(output);
			System.out.println("do it again???");
			
		}
		
			
	}
	
	static boolean isOperator(String str) {
		return str.equals("+")||
				str.equals("-")||
				str.equals("*")||
				str.equals("/");
	}

	
	

}
