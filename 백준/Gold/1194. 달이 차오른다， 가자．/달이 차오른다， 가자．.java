import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static char[][] map;
    static int[][][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node{
        int x;
        int y;
        int keys;
        Node(int x, int y, int keys){
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dist = new int[N][M][64];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (map[i][j] == '0'){
                    q.offer(new Node(i, j, 0));
                    dist[i][j][0] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curKeys = cur.keys;

            if(map[curX][curY] == '1') return dist[curX][curY][curKeys];

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(map[nextX][nextY] == '#') continue;
                // 열쇠를 만났을 때
                if(map[nextX][nextY] >= 'a' && map[nextX][nextY] <= 'f'){
                    int key = map[nextX][nextY] - 'a';
                    int mask = 1 << key;
                    int nextKeys = curKeys | mask; // 열쇠 줍기
                    if(dist[nextX][nextY][nextKeys] != -1) continue; // 이미 이 상태로 가봤으면 continue
                    dist[nextX][nextY][nextKeys] = dist[curX][curY][curKeys] + 1;
                    q.offer(new Node(nextX, nextY, nextKeys));
                }
                // 문을 만났을 때
                else if(map[nextX][nextY] >= 'A' && map[nextX][nextY] <= 'F'){
                    int door = (map[nextX][nextY] - 'A');
                    int mask = 1 << door;
                    if((curKeys & mask) == 0) continue;
                    if(dist[nextX][nextY][curKeys] != -1) continue;
                    dist[nextX][nextY][curKeys] = dist[curX][curY][curKeys] + 1;
                    q.offer(new Node(nextX, nextY, curKeys));
                }
                else{
                    if(dist[nextX][nextY][curKeys] != -1) continue;
                    dist[nextX][nextY][curKeys] = dist[curX][curY][curKeys] + 1;
                    q.offer(new Node(nextX, nextY, curKeys));
                }
            }
        }
        return -1;
    }
}