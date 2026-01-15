import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[] dist;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        count = new int[100001];
        Arrays.fill(dist, -1);
        dist[N] = 0;
        count[N] = 1;
        bfs();
        System.out.println(dist[K]);
        System.out.println(count[K]);
    }
    public static void bfs(){

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);

        while(!q.isEmpty()){
            int cur = q.poll();
            if(dist[K] != -1){
                if(dist[cur] > dist[K]) return;
            }
            int[] next = new int[]{cur-1, cur+1, cur*2};
            for(int n : next){
                if(n < 0 || n > 100000) continue;
                if(dist[n] == -1){
                    dist[n] = dist[cur] + 1;
                    count[n] = count[cur];
                    q.offer(n);
                } else if(dist[n] == dist[cur] + 1){ // 같은 최단거리로 또 도달했을 때!
                    count[n] += count[cur];
                }
            }
        }

    }
}