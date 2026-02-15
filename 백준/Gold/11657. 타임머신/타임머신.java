import java.io.*;
import java.util.*;

public class Main {

    static class Edge{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M;
    static List<Edge> edges;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        boolean result = bellmanFord(1);

        StringBuilder sb = new StringBuilder();
        if(!result) System.out.println(-1);
        else{
            for(int i=2; i<=N; i++) {
                if(dist[i] == INF) sb.append(-1).append('\n');
                else sb.append(dist[i]).append('\n');
            }
        }

        System.out.println(sb);

    }

    static boolean bellmanFord(int start){
        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // i번째 라운드가 끝나면 "간선 i개 이하로 갈 수 있는 최단거리"가 dist에 반영됨
        for(int i=1; i<=N; i++){
            for(int j=0; j<M; j++){
                Edge e = edges.get(j);

                if(dist[e.from] == INF) continue;

                if(dist[e.to] > dist[e.from] + e.weight) {
                    dist[e.to] = dist[e.from] + e.weight;
                    if(i == N) return false;
                }
            }
        }

        return true;
    }

}
