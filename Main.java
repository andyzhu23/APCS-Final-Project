/*
 * Author: Andy Zhu
 * @date    2022-05-19 10:53:54
 * @version 1.0.0
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br; static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static short readShort () throws IOException {
        return Short.parseShort(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readChar () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
    //----------------End of Template----------------
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new FileReader("in.txt"));
        int n = readInt(), m = readInt(), s = readInt(), t = readInt();
        Graph e = new Graph(n);
        for(int i = 1;i<=m;++i) {
            int u = readInt(), v = readInt(), f = readInt(), w = readInt();
            e.add(u, v, w, f);
        }
        Dinic solve = new Dinic(n, m, e, s, t);
        System.out.printf("Maximum Flow: %d\nMinimum Cost: %d\n", solve.dinic(), solve.cost());
        br.close();
    }
}