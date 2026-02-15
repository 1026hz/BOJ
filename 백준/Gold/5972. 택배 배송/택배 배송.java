import java.io.*;
import java.util.*;

public class Main {

    static class Edge{
        int nextVertex, nextWeight;
        Edge(int nextVertex, int nextWeight){
            this.nextVertex = nextVertex;
            this.nextWeight = nextWeight;
        }
    }
    static class State{
        int vertex, weight;
        State(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static int N, M;
    static List<Edge>[] edges;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N+1];
        for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        dijkstra(1);

        System.out.println(dist[N]);

    }

    static void dijkstra(int start){
        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(s -> s.weight));
        pq.offer(new State(start, 0));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            if(dist[cur.vertex] != cur.weight) continue;

            for(Edge e : edges[cur.vertex]){
                int nextVertex = e.nextVertex;
                int nextWeight = cur.weight + e.nextWeight;
                if(dist[nextVertex] > nextWeight){
                    dist[nextVertex] = nextWeight;
                    pq.offer(new State(nextVertex, nextWeight));
                }
            }
        }
    }

}
