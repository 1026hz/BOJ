import java.io.*;
import java.util.*;

public class Main {

    static class Edge{
        int a, b, w;
        Edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    static int V, E;
    static int[] rank;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges,(a,b) -> Integer.compare(a.w, b.w));
        makeSet(V);

        int picked = 0;
        int weight = 0;
        for(Edge e : edges){
            int a = e.a;
            int b = e.b;
            if(union(a,b)){
                weight += e.w;
                picked++;
            }
            if(picked == V - 1) break;
        }
        System.out.println(weight);

    }

    static void makeSet(int N){
        rank = new int[N+1];
        parent = new int[N+1];
        for(int i=0; i<N; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;
        if(a >= b) {
            parent[b] = a;
            rank[a]++;
        } else {
            parent[a] = b;
            rank[b]++;
        }
        return true;
    }

    static int find(int n){
        if(parent[n] == n) return n;
        parent[n] = find(parent[n]);
        return parent[n];
    }

}
