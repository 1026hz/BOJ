import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0,0));

    }

    public static int bfs(int x, int y){

        visited[x][y] = true;
        Deque<int []> dq = new ArrayDeque<>();
        dq.addLast(new int[]{x,y});

        while(!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            int nowX = now[0];
            int nowY = now[1];

            if(nowX == N - 1 && nowY == M - 1){
                return map[nowX][nowY];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (visited[nextX][nextY]) continue;
                if (map[nextX][nextY] == 0) continue;

                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[nowX][nowY] + 1;
                dq.addLast(new int[]{nextX, nextY});
            }
        }
        return -1;

    }

}
