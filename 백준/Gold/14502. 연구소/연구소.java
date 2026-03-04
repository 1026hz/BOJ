import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int ans = Integer.MIN_VALUE;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(ans);
    }

    public static void dfs(int startX, int startY, int count) {
        if (count == 3) {
            ans = Math.max(ans, bfs());
            return;
        }

        for(int i=startX; i<N; i++){
            for(int j = (i == startX ? startY : 0); j<M; j++){
                if(graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(i, j+1, count+1);
                    graph[i][j] = 0;
                }
            }
        }

    }

    public static int bfs() {
        int[][] bfsGraph = new int[N][M];
        for (int i = 0; i < N; i++) bfsGraph[i] = graph[i].clone();
        boolean[][] bfsVisited = new boolean[N][M];

        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (bfsGraph[i][j] == 2) {
                    q.offer(new Node(i, j));
                    bfsVisited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (bfsVisited[nextX][nextY]) continue;
                if (bfsGraph[nextX][nextY] != 0) continue;

                bfsGraph[nextX][nextY] = 2;
                q.offer(new Node(nextX, nextY));
                bfsVisited[nextX][nextY] = true;
            }

        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(bfsGraph[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

}
