import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int H;
    static int[][][] map;
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 1, -1, 0, 0};
    static class Node{
        int x;
        int y;
        int z;
        Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++){
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs(0, 0,0);
        int maxDay = 0;

        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if (map[h][n][m] > maxDay) maxDay = map[h][n][m];
                    if (map[h][n][m] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(maxDay - 1);

    }

    static void bfs(int x, int y, int z){

        Queue<Node> q = new ArrayDeque<>();

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[i][j][k] == 1){
                        q.offer(new Node(i,j,k));
                    }
                }
            }
        }

        while(!q.isEmpty()){

            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curZ = cur.z;

            for(int i=0; i<6; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextZ = curZ + dz[i];

                if(nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= H || nextY >= N || nextZ >= M) continue;
                if(map[nextX][nextY][nextZ] == -1) continue;
                if(map[nextX][nextY][nextZ] >= 1) continue;
                map[nextX][nextY][nextZ] = map[curX][curY][curZ] + 1;
                q.offer(new Node(nextX, nextY, nextZ));
            }
        }
    }

}
