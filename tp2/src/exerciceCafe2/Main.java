package exerciceCafe2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Café
		System.out.print("Type de café ? (Colombia / Expresso / Deca)\n");
		String type = scan.next();
		Coffee coffee;
		switch(type.toLowerCase()) {
			case "colombia":
				coffee = new ColombiaCoffee();
				break;
			case "expresso":
				coffee = new ExpressoCoffee();
				break;
			case "deca":
				coffee = new DecaCoffee();
				break;
			default:
				//Par défaut on choisi de mettre un expresso (on pourrait traiter les erreurs plus en profondeur dans un cas concret
				coffee = new ExpressoCoffee();
				System.out.println("Type de café inconnu");
				break;
		}

		// Suppléments
		System.out.print("Vous voulez un supplément ? oui / non\n");
		String avecSupplement = scan.next();
		while("oui".equalsIgnoreCase(avecSupplement)) {
			System.out.print("Supplément ? Lait+Caramel+Sucre+Chantilly)\n");
			String supplementInput = scan.next();
			Supplement supplement;
			switch(supplementInput.toLowerCase()) {
				case "lait":
					supplement = new Lait();
					coffee.addSupplement(supplement);
					break;
				case "caramel":
					supplement = new Caramel();
					coffee.addSupplement(supplement);
					break;
				case "chantilly":
					supplement = new Chantilly();
					coffee.addSupplement(supplement);
					break;
				case "sucre":
					supplement = new Sucre();
					coffee.addSupplement(supplement);
					break;
			}
			System.out.print("Vous voulez un supplément ? oui / non\n");
			avecSupplement = scan.next();
		}

		System.out.println(coffee);
	}
}
