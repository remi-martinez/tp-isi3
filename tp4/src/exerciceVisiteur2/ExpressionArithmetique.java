package exerciceVisiteur2;


public class ExpressionArithmetique {
	private Noeud racine;
	
	public ExpressionArithmetique(Noeud racine){
		this.racine = racine;
	}

	public Noeud getRacine() {
		return racine;
	}

	public void afficherPostFixe() {
		ConcreteVisitorPostfixDisplay cvpd = new ConcreteVisitorPostfixDisplay();
		racine.accept(cvpd);

		System.out.println("\n postfixe: " + cvpd.getResult());
	}

	public int calculerValeur() {
		ConcreteVisitorCalcul cvc = new ConcreteVisitorCalcul();
		racine.accept(cvc);

		return cvc.getResult();
	}

	
	public void afficherInFixe() {
		ConcreteVisitorInfixDisplay cvid = new ConcreteVisitorInfixDisplay();
		racine.accept(cvid);

		System.out.println("\n infixe: " + cvid.getResult());
	}
	
}
