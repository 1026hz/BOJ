import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        StringTokenizer st;
        int maxHeight = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if(now > maxHeight) maxHeight = now;
            }
        }

        int[] count = new int[maxHeight+1];

        for(int height=0; height<=maxHeight; height++) {
            visited = new boolean[N+1][N+1];
            int curCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        bfs(i, j, height);
                        curCount++;
                    }
                }
            }
            count[height] = curCount;
        }
        int max = 0;
        for(int i=0; i<=maxHeight; i++){
            if (count[i] > max) max = count[i];
        }
        System.out.println(max);

    }

    public static void bfs(int x, int y, int h){

        Queue<Node> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new Node(x,y));

        while(!q.isEmpty()){

            Node cur = q.poll();
            int nowX = cur.x;
            int nowY = cur.y;

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if(map[nextX][nextY] <= h) continue;
                if(visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                q.offer(new Node(nextX, nextY));
            }

        }

    }

}
