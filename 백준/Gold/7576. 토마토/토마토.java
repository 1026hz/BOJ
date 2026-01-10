import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int zeroCnt = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int now = Integer.parseInt(st.nextToken());
                if (now == 0) zeroCnt++;
                map[i][j] = now;
            }
        }

        if(zeroCnt == 0){
            System.out.println(0);
            return;
        }

        bfs();

        int maxDay = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                if (map[i][j] > maxDay) maxDay = map[i][j];
            }
        }

        System.out.println(maxDay-1);
    }

    public static void bfs(){

        Queue<Node> q = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1) q.offer(new Node(i,j));
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(map[nextX][nextY] == 0){
                    map[nextX][nextY] = map[curX][curY] + 1;
                    q.offer(new Node(nextX, nextY));
                }
            }
        }
    }



}
