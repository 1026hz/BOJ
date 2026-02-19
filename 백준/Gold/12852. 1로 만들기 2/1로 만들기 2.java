import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] visited;
    static int[] graph;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        Arrays.fill(visited, false);
        graph = new int[N+1];
        parent = new int[N+1];

        bfs();

        StringBuilder sb = new StringBuilder();
        sb.append(graph[N]).append('\n');
        int tmp = N;
        while(tmp > 1){
            sb.append(tmp).append(' ');
            tmp = parent[tmp];
        }
        sb.append(1);
        System.out.println(sb);
    }

    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == N) return;

            if(cur * 3 <= N && !visited[cur*3]) {
                q.offer(cur * 3);
                visited[cur * 3] = true;
                parent[cur * 3] = cur;
                graph[cur * 3] = graph[cur] + 1;
            }

            if(cur * 2 <= N && !visited[cur*2]) {
                q.offer(cur * 2);
                visited[cur * 2] = true;
                parent[cur * 2] = cur;
                graph[cur * 2] = graph[cur] + 1;
            }

            if(cur + 1 <= N && !visited[cur+1]) {
                q.offer(cur + 1);
                visited[cur + 1] = true;
                parent[cur + 1] = cur;
                graph[cur + 1] = graph[cur] + 1;
            }

        }
    }
}
