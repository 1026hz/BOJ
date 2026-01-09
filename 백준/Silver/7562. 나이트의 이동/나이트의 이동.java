import java.io.*;
import java.util.*;

public class Main {

    static int length;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] distance;
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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            length = Integer.parseInt(br.readLine());
            distance = new int[length][length];
            for (int j = 0; j < length; j++) Arrays.fill(distance[j], -1);

            st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());

            sb.append(bfs(nowX, nowY, nextX, nextY)).append('\n');
        }

        System.out.println(sb);
    }

    public static int bfs(int nowX, int nowY, int nextX, int nextY){
        if (nowX == nextX && nowY == nextY) return 0;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(nowX, nowY));
        distance[nowX][nowY] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for(int i=0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= length || ny >= length) continue;
                if(distance[nx][ny] != -1) continue;

                distance[nx][ny] = distance[x][y] + 1;
                if(nx == nextX && ny == nextY) return distance[nx][ny];

                q.offer(new Node(nx, ny));
            }
        }
        return -1;
    }




}
