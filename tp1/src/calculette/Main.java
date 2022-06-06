package calculette;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez l'operateur");
		String c = sc.nextLine();
		System.out.println("Saisissez le 1er nombre"); //saisir avec , et pas .
		float c1 = sc.nextFloat();
		System.out.println("Saisissez le 2nd nombre");
		float c2 = sc.nextFloat();

		Calculette calc = new Calculette(c1, c2, c);
		System.out.println(calc.calcul());
		


  }
}
