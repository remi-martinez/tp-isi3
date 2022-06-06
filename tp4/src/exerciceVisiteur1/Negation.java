package exerciceVisiteur1;

public class Negation extends OperateurUnaire{
	public Negation(Noeud n) {
		super("-", n);
	}

	@Override
	public int calculer() {
		return 0;
	}

}
