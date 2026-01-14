import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node{
        int x;
        int y;
        int status;
        Node(int x, int y, int status){
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

    }

    public static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curStatus = cur.status;

            if(curX == N-1 && curY == M-1) return visited[curX][curY][curStatus];

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                // 벽이 아닌 경우
                if(map[nextX][nextY] == 0){
                    if(visited[nextX][nextY][curStatus] == 0){
                        visited[nextX][nextY][curStatus] = visited[curX][curY][curStatus] + 1;
                        q.offer(new Node(nextX, nextY, curStatus));
                    }
                }

                // 벽인 경우
                else{
                    if(curStatus == 0 && visited[nextX][nextY][1] == 0){
                        visited[nextX][nextY][1] = visited[curX][curY][curStatus] + 1;
                        q.offer(new Node(nextX, nextY, 1));
                    }
                }

            }
        }

        return -1;
    }

}
