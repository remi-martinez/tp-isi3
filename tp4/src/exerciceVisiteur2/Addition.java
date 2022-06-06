package exerciceVisiteur2;

public class Addition extends OperateurBinaire{
	public Addition(Noeud ng, Noeud nd) {
		super("+", ng, nd);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visiterAddition(this);
	}
}
