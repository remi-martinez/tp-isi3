package exerciceCafe3;

import exerciceCafe3.coffee.*;
import exerciceCafe3.decorators.*;

public class Main {

	//Distributeur
	public static void main(String[] args) {

		SupplementDecorator c1 = new SucreDecorator(new ExpressoCoffee());
		SupplementDecorator c2 = new CaramelDecorator(new ChantillyDecorator(new ColombiaCoffee()));

		System.out.println("Expresso supplément sucre = " + c1.getFormattedPrice());
		System.out.println("Colombia supplément chantilly, caramel = " + c2.getFormattedPrice());
	}
}
