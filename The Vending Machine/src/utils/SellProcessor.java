package utils;
import models.Product;
import models.User;

public class SellProcessor implements SellOrganizer{

	@Override
	public void purchaseProduct(Product product, User user) {
		System.out.println("purchase has been done successfully!!!");
		user.updateBalance(-product.getPrice());	
	}

	@Override
	public void showInfo(Product product) {
		String name = product.getName();
		int price = product.getPrice();
		
		System.out.println("you have chosen to purchase a "+name);
		System.out.println("it costs "+price+"kr");
	}

	@Override
	public void showInstructions(Product product) {
		product.use();
	}

}
