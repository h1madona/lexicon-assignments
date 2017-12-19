package utilities;

import java.text.NumberFormat;

public class Utils {

	// take a double, format it, and return it as a String.
	public static String formatDouble(double num) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(1);
		return numberFormat.format(num);
	}

	// take a String, and print it.
	public static void print(String string) {
		System.out.println(string);
	}
}
