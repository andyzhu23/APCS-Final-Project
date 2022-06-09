
public class Blocking_Flow {
    public Graph e;
    public int[] cur;
    public boolean[] vis;
    public int n, m, S, T, ans;
    public int[] dist;
    /*
    Intialize a Blocking_Flow Object
    @param 
    N, an integer representing amount of node
    M, an integer representing amount of edges
    E, an object representing the graph
    s, an integer representing the start start
    t, an integer representing the ending node
    precondition:
    N, positive integer
    M, positive integer
    E, valid graph with n nodes and m edges
    s, a valid node between 1 and n
    t, a valid node between 1 and n
    postcondition:
    object created
    */
    public Blocking_Flow(int N, int M, Graph E, int s, int t) {
        n = N;
        m = M;
        e = E;
        cur = new int[e.head.length];
        for(int i = 0;i<e.head.length;++i) cur[i] = e.head[i];
        vis = new boolean[n + 5];
        dist = new int[n + 5];
        S = s;
        T = t;
        ans = 0;
    }
    /*
    get maximum flow for current blocking flow
    @param
    u, current node
    f, amount of flow
    precondition:
    u = S,
    f = infinity(super big number),
    postcondition:
    no longer able to flow from S to T, flows used are added to reverse edge
    maximum flow returned, ans variable has minimum cost.
    */
    public int dfs(int u, int f) {
        if(u == T) {
            ans += dist[u] * f;
            return f;
        }
        vis[u] = true;
        int ret = 0;
        for(;cur[u] > 0;cur[u] = e.get(cur[u]).nxt) {
            int i = cur[u];
            if(!vis[e.get(i).v] && dist[e.get(i).v] == dist[u] + e.get(i).w && e.get(i).f > 0) {
                int tmp = dfs(e.get(i).v, Math.min(f, e.get(i).f));
                e.get(i).f -= tmp;
                e.get(i ^ 1).f += tmp;
                f -= tmp;
                ret += tmp;
                if(f == 0) break;
            }
        }
        vis[u] = false;
        if(ret == 0) dist[u] = 0;
        return ret;
    }
}
