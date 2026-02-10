import java.io.*;
import java.util.*;

public class Main {

    static int[] rank;
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int a, b;
        double w;
        Edge(int a, int b, double w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
        @Override
        public int compareTo(Edge e){
            return Double.compare(this.w, e.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] x = new int[N+1];
        int[] y = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        rank = new int[N+1];
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            rank[i] = 0;
            parent[i] = i;
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        List<Edge> edges = new ArrayList<>();
        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                edges.add(new Edge(i, j, cal(x[i], y[i], x[j], y[j])));
            }
        }

        Collections.sort(edges);

        int picked = 0;
        double total = 0.0;
        for(Edge e : edges){
            int a = e.a;
            int b = e.b;
            if(union(a,b)){
                picked++;
                total += e.w;
                if(picked == N-1) break;
            }
        }

        System.out.printf("%.2f", total);

    }

    static double cal(int x1, int y1, int x2, int y2){
        return Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
    }

    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;
        if(rank[a] > rank[b]) parent[b] = a;
        else if(rank[b] > rank[a]) parent[a] = b;
        else{
            rank[a]++;
            parent[b] = a;
        }
        return true;
    }
}