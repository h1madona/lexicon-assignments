package models;

public class User {
	
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void updateBalance(int money) {
		this.balance += money;
		System.out.println("you have "+this.balance+"kr in your balance");
	}
	
	

}
