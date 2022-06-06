package graphe;

import java.util.LinkedList;
import java.util.Stack;

public class IterateurProfondeur extends Iterateur {

    protected Stack<Node> list;

    public IterateurProfondeur(IGraph graph, Node node) {
        super(graph,node);
        this.list = new Stack<>();
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
