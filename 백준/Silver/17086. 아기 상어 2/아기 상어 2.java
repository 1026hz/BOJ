import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][] ans;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ans = new int[N][M];

        for(int i=0; i<N; i++) Arrays.fill(ans[i], -1);

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) ans[i][j] = 0;
            }
        }
        bfs();

        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if (ans[i][j] > max) max = ans[i][j];
            }
        }
        System.out.println(max);

    }


    public static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(ans[i][j] == 0) q.offer(new Node(i, j));
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0; i<8; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(ans[nextX][nextY] == 0) continue;
                if(ans[nextX][nextY] != -1) continue;
                ans[nextX][nextY] = ans[curX][curY] + 1;
                q.offer(new Node(nextX, nextY));
            }
        }
    }

}