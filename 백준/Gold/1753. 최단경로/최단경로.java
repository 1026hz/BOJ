import java.io.*;
import java.util.*;

public class Main {

    static class Edge{
        int nextVertex, nextweight;
        Edge(int nextVertex, int nextweight){
            this.nextVertex = nextVertex;
            this.nextweight = nextweight;
        }
    }
    static class Status{
        int vertex;
        int weight;
        Status(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static int V,E,K;
    static List<Edge>[] graph;
    static final long INF = Long.MAX_VALUE;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(dist[i] != INF) sb.append(dist[i]).append('\n');
            else sb.append("INF").append('\n');
        }

        System.out.println(sb);
    }

    static void dijkstra(int start){
        dist = new long[V+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Status> pq = new PriorityQueue<>(Comparator.comparingLong(n -> n.weight));
        pq.offer(new Status(start, 0));

        while(!pq.isEmpty()){
            Status cur = pq.poll();
            int vertex = cur.vertex;
            int weight = cur.weight;

            if(dist[vertex] != weight) continue;

            for(Edge e : graph[vertex]){
                int nextVertex = e.nextVertex;
                int nextWeight = e.nextweight + weight;
                if(dist[nextVertex] > nextWeight) {
                    dist[nextVertex] = nextWeight;
                    pq.offer(new Status(nextVertex, nextWeight));
                }
            }
        }

    }

}
