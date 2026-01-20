import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int target1, target2;
    static List<Integer>[] map;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList[N+1];
        for(int i=1; i<=N; i++) map[i] = new ArrayList<>();

        dist = new int[N+1];
        Arrays.fill(dist, -1);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            map[parent].add(child);
            map[child].add(parent);
        }

        System.out.println(bfs());


    }

    public static int bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(target1);
        dist[target1] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == target2) return dist[cur];

            for(int next : map[cur]){
                if(dist[next] != -1) continue;
                dist[next] = dist[cur]+1;
                q.offer(next);
            }
        }

        return -1;
    }
}