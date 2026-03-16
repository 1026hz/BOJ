import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dist;
    static int[][] map;
    static class Node{
        int x, y, cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int maxLength = -1;
    static int maxAns = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N][M];
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0) bfs(i, j);
            }
        }
        if(maxLength == -1) System.out.println(0);
        else System.out.println(maxAns);
    }

    static void bfs(int x, int y){
        boolean [][] visited = new boolean[N][M];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;
        dist[x][y] = Math.max(dist[x][y], map[x][y]);

        while(!q.isEmpty()){
            Node cur = q.poll();
            int nowX = cur.x;
            int nowY = cur.y;
            int nowCnt = cur.cnt;
            int sum = map[x][y] + map[cur.x][cur.y];
            
            if(nowCnt > maxLength){
                maxLength = nowCnt;
                maxAns = sum;
            } else if (nowCnt == maxLength){
                maxAns = Math.max(maxAns, sum);
            }

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(map[nextX][nextY] == 0) continue;
                if(visited[nextX][nextY]) continue;
                q.offer(new Node(nextX, nextY, nowCnt + 1));
                visited[nextX][nextY] = true;
            }
        }
    }
}