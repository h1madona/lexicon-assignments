package models;

public class Snack extends Product {

	
	public Snack() {
		super("snack", 20);
	}


	@Override
	public void use() {
		System.out.println("Enjoy Your Snack!!!");
	}
	
	
	
}
