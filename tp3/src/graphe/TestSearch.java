package graphe;

public class TestSearch {

	public static void main(String[] args) {
		//exemple wikipedia: graph oriente
		Node na = new Node(new StringLabel("A"));
		Node nb = new Node(new StringLabel("B"));
		Node nc = new Node(new StringLabel("C"));
		Node nd = new Node(new StringLabel("D"));
		Node ne = new Node(new StringLabel("E"));
		Node nf = new Node(new StringLabel("F"));
		Node ng = new Node(new StringLabel("G"));


		Arc aa = new Arc(na,nb, null);
		Arc ab = new Arc(nb,nd, null);
		Arc ac = new Arc(nb,nf, null);
		Arc ad = new Arc(na,nc, null);
		Arc ae = new Arc(nc,ng, null);
		Arc af = new Arc(na,ne, null);
		Arc ag = new Arc(ne,nf, null);

		IDirectedGraph dg = new Graph();
		dg.addNode(na);dg.addNode(nb);dg.addNode(nc);dg.addNode(nd);dg.addNode(ne);dg.addNode(nf);dg.addNode(ng);
		dg.addArc(aa);dg.addArc(ab);dg.addArc(ac);dg.addArc(ad);dg.addArc(ae);dg.addArc(af);dg.addArc(ag);
		System.out.println(dg);

		Iterateur iterdgBGS= dg.creerBFSIterator(na);
		System.out.println("Wiki bfs:");
		while (iterdgBGS.hasNext())
			System.out.println(iterdgBGS.next());

		Iterateur iterdgDFS= dg.creerDFSIterator(na);
		System.out.println("Wiki dfs:");
		while (iterdgDFS.hasNext())
			System.out.println(iterdgDFS.next());

		//exemple graph non oriente
		System.out.println("Graph non oriente");

		IUndirectedGraph ug = new UndirectedGraph();
		ug.addNode(na);ug.addNode(nb);
		ug.addNode(nc);ug.addNode(nd);ug.addNode(ne);
		ug.addNode(nf);ug.addNode(ng);
		ug.addEdge(na, nb);
		ug.addEdge(nb, nd);
		ug.addEdge(nb, nf);
		ug.addEdge(na, nc);
		ug.addEdge(nc, ng);
		ug.addEdge(na, ne);
		ug.addEdge(ne, nf);

		Iterateur iterugBFS= ug.creerBFSIterator(na);
		System.out.println("bfs:");
		while (iterugBFS.hasNext())
			System.out.println(iterugBFS.next());

		Iterateur iterugDFS= ug.creerDFSIterator(na);
		System.out.println("dfs:");
		while (iterugDFS.hasNext())
			System.out.println(iterugDFS.next());

	}
}
