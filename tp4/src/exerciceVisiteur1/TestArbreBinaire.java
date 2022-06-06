package exerciceVisiteur1;



public class TestArbreBinaire {

	public static void main(String[] args) {
		//faire 1+2*3+-4=3
		Addition racine = new Addition(new Addition(new Constante(1),
					new Multiplication(new Constante(2),new Constante(3))),
					new Negation(new Constante(4)));
		ExpressionArithmetique exp = new ExpressionArithmetique(racine);

		exp.affichagePostfixe();
		System.out.println("\n calcul valeur: " + exp.calculerValeur());

		
		

	}

	

}
