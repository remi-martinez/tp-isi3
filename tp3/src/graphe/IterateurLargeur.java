package graphe;

import java.util.LinkedList;

public class IterateurLargeur extends Iterateur {

    protected LinkedList<Node> list;

    public IterateurLargeur(IGraph graph, Node node) {
        super(graph,node);
        this.list = new LinkedList<>();
        this.list.add(node);
    }

    @Override
    public Node next() {
        currentNode = list.pop();
        graph.getAdjNodes(currentNode).forEach(voisin -> {
            if (!marquer.contains(voisin)) {
                list.add(voisin);
                marquer.add(voisin);
            }
        });
        return currentNode;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return !this.list.isEmpty();
    }
}
