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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int yearCnt = 0;
        int iceCnt = 1;

        while(iceCnt < 2){
            yearBfs();
            yearCnt++;
            iceCnt = countBfs();
            if(iceCnt == 0) {
               System.out.println(0);
               return;
            }
        }
        System.out.println(yearCnt);
    }

    static void yearBfs(){
        int[][] melt = new int[N+1][M+1];

        Queue<Node> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j] != 0) q.offer(new Node(i, j));
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            int count0 = 0;
            for(int i=0; i<4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if(nextX <= 0 || nextX > N || nextY <= 0 || nextY > M) continue;
                if(map[nextX][nextY] == 0) count0++;
            }
            melt[cur.x][cur.y] = count0;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j] - melt[i][j] <= 0) map[i][j] = 0;
                else map[i][j] -= melt[i][j];
            }
        }

    }

    static int countBfs(){
        int countIce = 0;
        boolean[][] visited = new boolean[N+1][M+1];
        Queue<Node> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if (map[i][j] != 0 && !visited[i][j]) {
                    q.offer(new Node(i,j));
                    visited[i][j] = true;
                    countIce++;
                }
                while(!q.isEmpty()){
                    Node cur = q.poll();

                    for(int k=0; k<4; k++){
                        int nextX = cur.x + dx[k];
                        int nextY = cur.y + dy[k];

                        if(nextX <= 0 || nextX > N || nextY <= 0 || nextY > M) continue;
                        if(map[nextX][nextY] == 0) continue;
                        if(visited[nextX][nextY]) continue;

                        visited[nextX][nextY] = true;
                        q.offer(new Node(nextX, nextY));
                    }
                }
            }
        }
        return countIce;
    }
}
