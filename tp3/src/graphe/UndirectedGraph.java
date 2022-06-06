package graphe;

public class UndirectedGraph extends Graph implements IUndirectedGraph{

    /**
     * Ajoute une arrete au graph entre deux noeuds
     *
     * @param _node1 : le premier noeud
     * @param _node2 : le deuxième noeud
     */
    @Override
    public void addEdge(Node _node1, Node _node2) {
        super.addArc(new Arc(_node1, _node2, null));
        super.addArc(new Arc(_node2, _node1, null));
    }

    /**
     * @param _node1 : le premier noeud
     * @param _node2 : le deuxième noeud
     * @return vrai si le graph possede une arrete entre les noeuds _n1 et _n2
     */
    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        return super.hasArc(_node1, _node2) || super.hasArc(_node2, _node1);
    }
}
