package strategycalculette;

import strategybeers.*;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez l'operateur");
		String c = sc.nextLine();
		System.out.println("Saisissez le 1er nombre");//saisir avec , et pas . 
		Float c1 = sc.nextFloat();
		System.out.println("Saisissez le 2nd nombre");
		Float c2 = sc.nextFloat();

		/* initialize strategy */
		ICalculStrategy addition = new Addition();
		ICalculStrategy soustraction = new Soustraction();
		ICalculStrategy multiplication = new Multiplication();
		ICalculStrategy division = new Division();

		CalculetteStrat calcStrat = new CalculetteStrat(c1 ,c2);

		switch(c) {
			case "+":
				calcStrat.setCalculStrategy(addition);
			case "-":
				calcStrat.setCalculStrategy(soustraction);
			case "*":
				calcStrat.setCalculStrategy(multiplication);
			case "/":
				calcStrat.setCalculStrategy(division);
		}

		System.out.println(calcStrat.calcul());

  }
}
