package ui;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import models.Chocolate;
import models.Drink;
import models.Product;
import models.Snack;
import models.User;
import utils.SellProcessor;

public class VendingMachine {
	private static Scanner scanner;
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		new VendingMachine().start();
	}
	
	private void start() {
		User user = new User();
		do {
			if(user.getBalance()>0) {
				System.out.println("you still have "+user.getBalance()+"kr left");
				System.out.println("would you like to buy something else ???");
			}
				
			//set the money denominations.
			int[] moneyDenom = {1, 5, 10, 20, 50, 100, 500, 1000};
			
			//put the products into array to loop through and manipulate properties.
			Product drink = new Drink();
			Product snack = new Snack();
			Product chocolate = new Chocolate();
			Product[] products = {drink, snack, chocolate};
			
			//display products.
			System.out.println("Available Products");
			System.out.println("-----------");
			for(int i=0; i<products.length; i++) {
				System.out.println(products[i].getName()+"\t Price: "+products[i].getPrice()+"kr");
			}
			System.out.println("----------");
			
			//create sell organizer instance to help organize the purchase.
			SellProcessor sellProcessor = new SellProcessor();
			Product chosenProduct;
			String userSelection = "";
			int moneyRequired = 0;
			int moneyPayed = 0;
			
			
			//keep looping until you get correct product.
			while(true){
				//ask user to select a product.
				System.out.print("Choose a Product: ");
				userSelection = scanner.nextLine().trim();
				if(userSelection.equalsIgnoreCase(drink.getName())) {
					chosenProduct = drink;
					moneyRequired = drink.getPrice();
					sellProcessor.showInfo(drink);
					break;
				}else if(userSelection.equalsIgnoreCase(snack.getName())) {
					chosenProduct = snack;
					moneyRequired = snack.getPrice();
					sellProcessor.showInfo(snack);
					break;
					
				}else if(userSelection.equalsIgnoreCase(chocolate.getName())) {
					chosenProduct = chocolate;
					moneyRequired = chocolate.getPrice();
					sellProcessor.showInfo(chocolate);
					break;
				}else {
					System.out.println("Invalid Product Name!!");
				}
				
			}
			
			//get payment from user only if he has no previous balance.
			if(user.getBalance()<=0) {
				//ask user for money.
				System.out.println("Please Pay "+moneyRequired+"kr");
				System.out.println("Accepted Money Denominitions are:");
				for(int i=0; i<moneyDenom.length; i++) {
					System.out.print(moneyDenom[i]+" ");
				}
				
				
				getPayment(moneyPayed, moneyRequired, moneyDenom, user);
			}
			if(user.getBalance()>=moneyRequired) {
				//everything is ok, continue to purchase chosen product.
				sellProcessor.purchaseProduct(chosenProduct, user);
				sellProcessor.showInstructions(chosenProduct);
				System.out.println("-------------------------");
			}
			else {
				//if the user has balance, but it's not enough.
				System.out.println("balance is not enough!!");
				
			}
			
		}while(user.getBalance()>0);
	
	}
	
	
	//this method will get the payment from the user.
	private void getPayment(int moneyPayed,int moneyRequired, int[] moneyDenom, User user) {
		//keep looping to get enough money and correct denomination.
				while(true) {
					try {
						moneyPayed = scanner.nextInt();
					}catch(InputMismatchException e){
						System.out.println("INVALID MONEY!!!");
						continue;
					}finally {
						scanner.nextLine();
					}
					
				//check money denomination.
					if(Arrays.binarySearch(moneyDenom, moneyPayed)<0) {
						System.out.println("Please Enter a Correct Denomination!!");
						continue;
					}
					if(moneyPayed<moneyRequired) {
						System.out.println("Not Enough Money!!");
						continue;
					}else if(moneyPayed>=moneyRequired) {
						user.updateBalance(moneyPayed);
						break;
					}
				}
	}
	
}
