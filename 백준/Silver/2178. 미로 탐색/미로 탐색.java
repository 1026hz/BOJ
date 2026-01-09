import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] distance;
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

        map = new int[N][M];
        distance = new int[N][M];
        for(int i=0; i<N; i++) Arrays.fill(distance[i], -1);

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j)- '0';
            }
        }
        bfs(0, 0);
        System.out.println(distance[N-1][M-1]);
    }

    public static void bfs(int x, int y){

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y));
        distance[x][y] = 1;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위를 나가면 continue
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                // 이미 방문했으면 continue
                if(distance[nextX][nextY] != -1) continue;
                // 0이라서 못 가는 곳이면 continue
                if(map[nextX][nextY] == 0) continue;

                distance[nextX][nextY] = distance[curX][curY] + 1;
                q.add(new Node(nextX,nextY));
            }
        }
    }

}
