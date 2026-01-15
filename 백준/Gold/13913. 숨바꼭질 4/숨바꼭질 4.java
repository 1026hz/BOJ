import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[] dist;
    static int[] from;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        Arrays.fill(dist, -1);

        from = new int[100001];
        Arrays.fill(from, -1);

        bfs();

        System.out.println(dist[K]);

        int start = K;
        List<Integer> route = new ArrayList<>();
        while(start != N){
            route.add(start);
            start = from[start];
        } route.add(N);

        StringBuilder sb = new StringBuilder();
        for(int i = route.size()-1; i>=0; i--){
            sb.append(route.get(i)).append(' ');
        }

        System.out.println(sb);

    }
    public static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        dist[N] = 0;
        from[N] = N;

        while(!q.isEmpty()){
            int cur = q.poll();
            int[] nextArr = {cur-1, cur+1, cur*2};
            for(int next : nextArr){
                if(next < 0 || next > 100000) continue;
                if(dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                from[next] = cur;
                q.offer(next);
            }
        }

    }
}