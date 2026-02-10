import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;

    static class Edge implements Comparable<Edge>{
        int a,b,w;
        Edge(int a, int b, int w){
            this.a = a;
            this.b = b;
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

        Edge[] edges = new Edge[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, w);
        }

        parent = new int[N+1];
        rank = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        Arrays.sort(edges);

        int picked = 0;
        int total = 0;
        int max = 0;

        for(Edge e : edges){
            int a = e.a;
            int b = e.b;
            if(union(a,b)){
                if(e.w > max) max = e.w;
                total += e.w;
                picked++;

                if(picked == N-1) break;
            }
        }

        System.out.println(total - max);


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