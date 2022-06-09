import java.util.*;

public class Dinic extends Blocking_Flow {
    public boolean[] inq;
    public final int inf = 0x3f3f3f3f;
    /*
    Initialize Dinic Object
    @param 
    N, an integer representing amount of node
    M, an integer representing amount of edges
    E, an object representing the graph
    s, an integer representing the start start
    t, an integer representing the ending node
    @precondition
    N, positive integer
    M, positive integer
    E, valid graph with n nodes and m edges
    s, a valid node between 1 and n
    t, a valid node between 1 and n
    @postcondition
    object created
    */
    public Dinic(int N, int M, Graph E, int s, int t) {
        super(N, M, E, s, t);
        inq = new boolean[N + 5];
    }
    /*
    Build Level Graph
    @param: no parameter
    precondition: no precondition
    postcondition: 
    level graph built according to minimum weight,
    super.dist is the minimum path from S to any node
    */
    public boolean spfa() {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        for(int i = 0;i<super.dist.length;++i) super.dist[i] = inf;
        for(int i = 0;i<=n;++i) super.cur[i] = super.e.head[i];
        super.dist[S] = 0;
        while(!q.isEmpty()) {
            int u = q.remove();
            inq[u] = false;
            for(int i = super.e.head[u];i > 0;i=super.e.get(i).nxt) {
                if(e.get(i).f > 0 && super.dist[e.get(i).v] > super.dist[u] + e.get(i).w) {
                    super.dist[e.get(i).v] = super.dist[u] + e.get(i).w;
                    if(!inq[e.get(i).v]) {
                        inq[e.get(i).v] = true;;
                        q.add(e.get(i).v);
                    }
                }
            }
        }
        return super.dist[T] != inf;
    }
    /*
    Do Dinic algorithm
    @param: no parameter
    precondition: no precondition
    postcondition: 
    no longer able to reach from S to T when building level graph
    all flow that are able to flow has been flowed.
    maximum flow is returned
    */
    public int dinic() {
        int ans = 0;
        while(spfa()) ans += super.dfs(super.S, 0x3f3f3f3f);
        return ans;
    }
    /*
    return minimum cost
    @param: no parameter
    precondition: dinic method has been called
    postcondition: 
    value of minimum cost is returned.
    */
    public int cost() {
        return super.ans;
    }
}
