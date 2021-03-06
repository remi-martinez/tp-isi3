package exerciceVisiteur2;


public abstract class OperateurUnaire implements Noeud{
	private String op;
	private Noeud opG;
	
	OperateurUnaire(String s,Noeud n){
		op=s;
		opG=n;
	}

	public String getOp(){
		return op;
	}
	public Noeud getOpG(){
		return opG;
	}

	public abstract void accept(Visitor visitor);
}
