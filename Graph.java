import java.util.*;

public class Graph {
    private ArrayList<Edge> e;
    private int tot, n;
    public int[] head;
    /* 
    Initialize Graph Object
    @param N is a positive integer
    */
    public Graph(int N) {
        e = new ArrayList<Edge>();
        e.add(new Edge(0, 0, 0, 0, 0));
        e.add(new Edge(0, 0, 0, 0, 0));
        tot = 1;
        n = N;
        head = new int[n + 5];
    }
    /*
    return the value of tot
    */
    public int getTot() {
        return tot;
    }
    /*
    return the Edge object at index x
    @param x, the index in arraylist e that user want to get
    */
    public Edge get(int x) {
        return e.get(x);
    }
    /*
    add the edge
    @param 
    u: the current node, 
    v: the node you are going to, 
    w: the weight of the node, 
    f: the flow capacity of the node,
    precondition: u and v need to be index of a node between 1 and n, w and f need to be integer
    postcondition: two new edges are added, normal edge, and reverse edge.
    */
    public void add(int u, int v, int w, int f) {
        e.add(new Edge(u, v, w, f, head[u]));
        head[u] = ++tot;
        e.add(new Edge(v, u, -w, 0, head[v]));
        head[v] = ++tot;
    }
    /*
    add the edge
    @param 
    u: the current node, 
    v: the node you are going to, 
    f: the flow capacity of the node,
    precondition: u and v need to be index of a node between 1 and n, f need to be integer
    postcondition: two new edges with no weight are added, normal edge, and reverse edge.
    */
    public void add(int u, int v, int f) {
        e.add(new Edge(u, v, 1, f, head[u]));
        head[u] = ++tot;
        e.add(new Edge(v, u, 1, 0, head[v]));
        head[v] = ++tot;
    }
}
