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

    static int N, M, X;
    static List<Edge>[] graph;
    static long[] totalTime;
    static long[] time;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        for(int i=1; i<=M; i++){
            st  = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());;
            graph[from].add(new Edge(to, weight));
        }

        totalTime = new long[N+1];

        for(int i=1; i<=N; i++){
            time = new long[N+1];
            Arrays.fill(time, INF);
            dijkstra(i);
            if(i != X && time[X] != INF) totalTime[i] += time[X];
            if(i == X){
                for(int j=1; j<=N; j++){
                    totalTime[j] += time[j];
                }
            }
        }

        long max = 0;
        for(int i=1; i<=N; i++){
            if (totalTime[i] > max) max = totalTime[i];
        }

        System.out.println(max);

    }

    static void dijkstra(int start){
        time[start] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(s -> s.weight));
        pq.offer(new State(start, 0));

        while(!pq.isEmpty()){
            State cur = pq.poll();

            if(time[cur.vertex] != cur.weight) continue;

            for(Edge e : graph[cur.vertex]){
                int nextVertex = e.nextVertex;
                int nextWeight = e.nextWeight + cur.weight;
                if(time[nextVertex] > nextWeight) {
                    time[nextVertex] = nextWeight;
                    pq.offer(new State(nextVertex, nextWeight));
                }
            }
        }

    }

}
