import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        Arrays.fill(dist, -1);

        bfs();
        System.out.println(dist[K]);

    }

    public static void bfs(){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);
        dist[N] = 0;

        while(!dq.isEmpty()){
            int cur = dq.poll();

            if(cur == K) return;

            int[] nextArr = {cur*2, cur+1 , cur-1};
            for(int next : nextArr){
                if(next < 0 || next > 100000) continue;

                int nextDist = dist[cur];
                if(next != cur * 2) nextDist++;

                if (dist[next] == -1 || dist[next] > nextDist) {
                    dist[next] = nextDist;
                    if (next == cur * 2) dq.addFirst(next);
                    else dq.addLast(next);
                }
            }
        }
    }
}