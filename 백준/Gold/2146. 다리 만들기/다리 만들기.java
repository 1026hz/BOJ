import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count;

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        landBfs();

        int ans = Integer.MAX_VALUE;
        for(int i=2; i<=count; i++){
            dist = new int[N][N];
            for(int j=0; j<N; j++){
                Arrays.fill(dist[j], -1);
            }
            ans = Math.min(ans, oceanBfs(i));
        }

        System.out.println(ans);
    }

    public static void landBfs(){
        count = 2;
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {

                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = count;
                    q.offer(new Node(i, j));

                    while (!q.isEmpty()) {
                        Node cur = q.poll();
                        int curX = cur.x;
                        int curY = cur.y;

                        for (int k = 0; k < 4; k++) {
                            int nextX = curX + dx[k];
                            int nextY = curY + dy[k];

                            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                                continue;
                            if (map[nextX][nextY] == 0)
                                continue;
                            if (visited[nextX][nextY])
                                continue;
                            map[nextX][nextY] = count;
                            visited[nextX][nextY] = true;
                            q.offer(new Node(nextX, nextY));
                        }
                    }
                    count++;
                }
            }
        }
    }

    public static int oceanBfs(int landNum){
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == landNum) {
                    dist[i][j] = 0;
                    q.offer(new Node(i, j));
                }
            }
        }
        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                // 이미 방문한 곳일 때
                if(dist[nextX][nextY] != -1) continue;
                // 다음이 바다일 때
                if(map[nextX][nextY] == 0){
                    dist[nextX][nextY] = dist[curX][curY] + 1;
                    q.offer(new Node(nextX, nextY));
                }
                // 현재 육지인데 다음이 육지일 때
                if(map[curX][curY] == landNum && map[nextX][nextY] == landNum) {
                    dist[nextX][nextY] = 0;
                    q.offer(new Node(nextX, nextY));
                }
                // 현재 바다인데 다음이 다른 육지일 때
                if(map[curX][curY] == 0 && map[nextX][nextY] != 0 && map[nextX][nextY] != landNum){
                    return dist[curX][curY];
                }
            }
        }
        return Integer.MAX_VALUE;
    }

}