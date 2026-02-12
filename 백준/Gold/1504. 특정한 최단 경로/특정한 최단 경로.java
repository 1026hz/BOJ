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

    static int N, E;
    static List<Edge>[] graph;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<=E; i++){
            st  = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight));
        }

        st  = new StringTokenizer(br.readLine());
        int must1 = Integer.parseInt(st.nextToken());
        int must2 = Integer.parseInt(st.nextToken());

        long ans1 = 0;
        long ans2 = 0;

        dijkstra(1);
        if(dist[must1] != INF) ans1 += dist[must1];
        if(dist[must2] != INF) ans2 += dist[must2];

        dijkstra(must1);
        if(dist[must2] != INF) ans1 += dist[must2];

        dijkstra(must2);
        if(dist[N] != INF) ans1 += dist[N];
        else ans1 = -1;

        dijkstra(must2);
        if(dist[must1] != INF) ans2 += dist[must1];

        dijkstra(must1);
        if(dist[N] != INF) ans2 += dist[N];
        else ans2 = -1;

        System.out.println(Math.min(ans1, ans2));
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
            for(Edge e : graph[cur.vertex]){
                int nextVertex = e.nextVertex;
                int nextWeight = e.nextWeight + cur.weight;
                if(dist[nextVertex] > nextWeight){
                    dist[nextVertex] = nextWeight;
                    pq.offer(new State(nextVertex, nextWeight));
                }
            }
        }
    }

}
