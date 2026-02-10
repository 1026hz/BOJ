import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] rank;

    static class Edge implements Comparable<Edge>{
        int a, b, w;

        Edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, w);
        }

        makeSet(V);
        Arrays.sort(edges);

        int total = 0;
        int picked = 0;

        for(Edge e : edges){
            int a = e.a;
            int b = e.b;
            if(union(a,b)){
                total += e.w;
                picked++;

                if(picked == V-1) break;
            }
        }

        System.out.println(total);
    }

    static void makeSet(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int find(int n){
        if(parent[n] == n) return n;
        parent[n] = find(parent[n]);
        return parent[n];
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;
        if(rank[a] > rank[b]) parent[b] = a;
        else if(rank[b] > rank[a]) parent[a] = b;
        else{
            rank[a]++;
            parent[b] = a;
        }

        return true;
    }

}