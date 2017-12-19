package utils;
import models.Product;
import models.User;

public interface SellOrganizer {
	
	//organize the process of purchasing product by updating user balance.
	void purchaseProduct(Product product, User user);
	//show informations about the product, eg. price and name.
	void showInfo(Product product);
	//show instruction to use the product.
	void showInstructions(Product product);
	
}
