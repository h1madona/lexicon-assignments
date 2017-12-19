package models;

public class Drink extends Product {

	
	
	public Drink() {
		super("drink", 10);
	}
	

	@Override
	public void use() {
		System.out.println("Enjoy Your Drink!!!");
	}
	
	
}
