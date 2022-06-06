package exerciceCafe1;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Coffee colombiaCoffee = new ColombiaCoffee();
		Coffee expressoCoffee = new ExpressoCoffee();
		Coffee decaCoffee = new DecaCoffee();

		Scanner scan = new Scanner(System.in);
		System.out.print("Type de café ? (Colombia / Expresso / Deca)\n");
		String type = scan.next();

		switch(type.toLowerCase()) {
			case "colombia":
				System.out.println(colombiaCoffee);
				break;
			case "expresso":
				System.out.println(expressoCoffee);
				break;
			case "deca":
				System.out.println(decaCoffee);
				break;
			default:
				System.out.println("Type de café inconnu");
		}
	}
}
