public class Edge {
    public int u, v, w, f, nxt;
    /*
    an Edge object is constructed
    add the edge
    @param 
    u: the current node, 
    v: the node you are going to, 
    w: the weight of the node, 
    f: the flow capacity of the node,
    precondition: u and v need to be index of a node between 1 and n, w and f need to be integer
    postcondition: a new edge object is constructed.
    */
    public Edge(int U, int V, int W, int F, int NXT) {
        u = U;
        v = V;
        w = W;
        f = F;
        nxt = NXT;
    }
}
