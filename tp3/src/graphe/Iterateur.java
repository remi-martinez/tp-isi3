package graphe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Iterateur implements Iterator<Node> {

    protected IGraph graph;
    protected Node currentNode;
    protected List<Node> marquer;

    public Iterateur(IGraph graph, Node node)
    {
        this.graph = graph;
        this.currentNode = node;
        this.marquer = new ArrayList<Node>();
        this.marquer.add(node);
    }

    public IGraph getGraph() {
        return graph;
    }

    public void setGraph(IGraph graph) {
        this.graph = graph;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        currentNode = currentNode;
    }

    public abstract Node next();

    public boolean finished() {
        return this.hasNext();
    }

}
