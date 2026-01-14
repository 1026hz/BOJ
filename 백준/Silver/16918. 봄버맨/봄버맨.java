import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static int N;
    static int[][] bomb;
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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        bomb = new int[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++){
                if(s.charAt(j) == '.') bomb[i][j] = -1;
                else bomb[i][j] = 0;
            }
        }

        int cnt = 1;
        while(cnt <= N+1){

            if(cnt > 2) {
                if (cnt % 2 == 1) {
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            if (bomb[i][j] == -1)
                                bomb[i][j] = 0;
                        }
                    }
                } else {
                    destroyBombBfs();
                }
            }

            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(bomb[i][j] >= 0) bomb[i][j] = bomb[i][j] + 1;
                }
            }

            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(bomb[i][j] == -1) sb.append('.');
                else sb.append('O');
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    public static void destroyBombBfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(bomb[i][j] == 3) q.offer(new Node(i,j));
            }
        }
        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                if(bomb[nextX][nextY] == -1) continue;
                bomb[nextX][nextY] = -1;
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(bomb[i][j] == 3) bomb[i][j] = -1;
            }
        }
    }

}
