package models;

public class Chocolate extends Product {
	
	
	
	
	public Chocolate() {
		super("kitkat", 5);
	}


	@Override
	public void use() {
		System.out.println("suck the chocolate, it lasts longer!!!");
	}
	
	
}
