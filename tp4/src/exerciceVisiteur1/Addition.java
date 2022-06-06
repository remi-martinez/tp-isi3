package exerciceVisiteur1;

public class Addition extends OperateurBinaire{
	public Addition(Noeud ng, Noeud nd) {
		super("+", ng, nd);
	}

	@Override
	public int calculer() {
		return 0;
	}
	

}
