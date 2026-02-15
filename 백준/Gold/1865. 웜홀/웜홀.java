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

    static int TC, N, M, W;
    static List<Edge> edges;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for(int i=1; i<=M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }

            for(int i=1; i<=W; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -t));
            }

            boolean isNegative = fw();
            if(isNegative) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }

    static boolean fw(){
        dist = new long[N+1];
        Arrays.fill(dist, 0L);

        for(int i=1; i<=N; i++){
            for(int j=0; j<edges.size(); j++){
                Edge e = edges.get(j);
                if(dist[e.to] > dist[e.from] + e.weight) {
                    dist[e.to] = dist[e.from] + e.weight;
                    if(i == N) return true;
                }
            }
        }
        return false;
    }


}
