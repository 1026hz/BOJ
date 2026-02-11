import java.io.*;
import java.util.*;

public class Main {

    static class Edge{
        int nextVertex;
        int nextWeight;
        Edge(int nextVertex, int nextWeight){
            this.nextVertex = nextVertex;
            this.nextWeight = nextWeight;
        }
    }

    static class State{
        int vertex;
        int weight;
        State(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static int N, M;
    static List<Edge>[] graph;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dijkstra(start);

        System.out.println(dist[end]);

    }

    static void dijkstra(int start){
        dist[start] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(s -> s.weight));
        pq.offer(new State(start ,0));

        while(!pq.isEmpty()){
            State cur = pq.poll();

            if(cur.weight != dist[cur.vertex]) continue;

            for(Edge e : graph[cur.vertex]){
                int nextVertex = e.nextVertex;
                int nextWeight = e.nextWeight + cur.weight;

                if(dist[nextVertex] > nextWeight) {
                    dist[nextVertex] = nextWeight;
                    pq.offer(new State(nextVertex, nextWeight));
                }

            }
        }

    }

}
