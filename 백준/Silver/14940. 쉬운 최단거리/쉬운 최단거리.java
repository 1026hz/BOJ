import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int x, y, status;
        Node(int x, int y, int status){
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] graph;
    static int[][] ans;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        ans = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=1; i<=N; i++) Arrays.fill(ans[i], -1);
        int targetX = 0;
        int targetY = 0;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                int n = Integer.parseInt(st.nextToken());
                graph[i][j] = n;
                if(n == 2) {
                    targetX = i;
                    targetY = j;
                }
                else if (n == 0) ans[i][j] = 0;
            }
        }
        bfs(targetX, targetY);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                sb.append(ans[i][j]).append(' ');
            }sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x,y,0));
        ans[x][y] = 0;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curStatus = cur.status;

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextStatus = curStatus + 1;

                if(nextX <= 0 || nextY <= 0 || nextX > N || nextY > M) continue;
                if(visited[nextX][nextY]) continue;
                if(graph[nextX][nextY] == 0) continue;

                visited[nextX][nextY] = true;
                ans[nextX][nextY] = nextStatus;
                q.offer(new Node(nextX, nextY, nextStatus));
            }


        }
    }
}
