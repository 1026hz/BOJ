import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] status;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node{
        int x;
        int y;
        Node(int x, int y) {
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
        status = new int[N][M];
        for(int i=0; i<N; i++) {
            Arrays.fill(status[i], -1);
        }
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(status[N-1][M-1]);

    }

    public static void bfs(){
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(0,0));
        status[0][0] = 0;

        while(!dq.isEmpty()){
            Node cur = dq.poll();
            int curX = cur.x;
            int curY = cur.y;
            if(curX == N-1 && curY == M-1) return;

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                int nextStatus = status[curX][curY];
                if(map[nextX][nextY] == 1) nextStatus++;

                if(status[nextX][nextY] == -1 || status[nextX][nextY] > nextStatus) {
                    status[nextX][nextY] = nextStatus;
                    if(map[nextX][nextY] == 0) dq.addFirst(new Node(nextX, nextY));
                    else dq.offer(new Node(nextX, nextY));
                }

            }


        }
    }


}