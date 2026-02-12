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
    static List<Edge>[] graph;
    static long[] dist;
    static int[] parent;
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
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append('\n');

        int nowIdx = end;
        List<Integer> path = new ArrayList<>();
        path.add(end);
        while(nowIdx != start){
            nowIdx = parent[nowIdx];
            path.add(nowIdx);
        }

        sb.append(path.size()).append('\n');

        for(int i=path.size()-1; i>=0; i--){
            sb.append(path.get(i)).append(' ');
        }

        System.out.println(sb);

    }

    static void dijkstra(int start){
        dist = new long[N+1];
        parent = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(s -> s.weight));
        pq.offer(new State(start , 0));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            if(dist[cur.vertex] != cur.weight) continue;

            for(Edge e : graph[cur.vertex]){
                int nextVertex = e.nextVertex;
                int nextWeight = e.nextWeight + cur.weight;

                if(dist[nextVertex] > nextWeight){
                    dist[nextVertex] = nextWeight;
                    parent[nextVertex] = cur.vertex;
                    pq.offer(new State(nextVertex, nextWeight));
                }

            }
        }



    }

}
