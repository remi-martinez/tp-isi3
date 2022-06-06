package exerciceVisiteur2;


public class Negation extends OperateurUnaire{
	public Negation(Noeud n) {
		super("-", n);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visiterNegation(this);
	}
}
