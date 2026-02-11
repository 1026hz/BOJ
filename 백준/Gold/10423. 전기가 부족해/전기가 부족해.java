import java.io.*;
import java.util.*;

public class Main {

    static boolean[] powerStation;
    static int[] rank;
    static int[] parent;

    static class Edge implements Comparable<Edge>{

        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e){
            return Integer.compare(this.w, e.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        powerStation = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            powerStation[Integer.parseInt(st.nextToken())] = true;
        }

        Edge[] edges = new Edge[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, w);
        }

        rank = new int[N+1];
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            rank[i] = 0;
            parent[i] = i;
        }

        Arrays.sort(edges);

        int total = 0;
        int picked = 0;
        int max = 0;
        for(Edge e : edges){
           int a = e.u;
           int b = e.v;
           if(union(a,b)){
               picked++;
               total += e.w;
               if(picked == N-K) break;
           }
        }

        System.out.println(total);
    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if (a == b) return false;
        if (powerStation[a] && powerStation[b]) return false;
        if (rank[a] > rank[b]) {
            parent[b] = a;
            powerStation[a] = powerStation[a] || powerStation[b];
        }
        else if (rank[b] > rank[a]) {
            parent[a] = b;
            powerStation[b] = powerStation[a] || powerStation[b];
        }
        else{
            rank[a]++;
            parent[b] = a;
            powerStation[a] = powerStation[a] || powerStation[b];
        }
        return true;
    }

}