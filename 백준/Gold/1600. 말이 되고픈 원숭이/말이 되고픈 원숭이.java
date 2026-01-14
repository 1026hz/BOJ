import java.io.*;
import java.util.*;

public class Main {

    static int K, W, H;
    static int[][] map;
    static int[][][] dist;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] horseDx = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] horseDy = {2, 1, 2, 1, -2, -1, -2, -1};

    static class Node {
        int x, y, status;
        Node(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        dist = new int[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));
        dist[0][0][0] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curStatus = cur.status;

            if (curX == H - 1 && curY == W - 1) return dist[curX][curY][curStatus];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) continue;
                if (map[nextX][nextY] == 1) continue;
                if (dist[nextX][nextY][curStatus] != -1) continue;

                dist[nextX][nextY][curStatus] = dist[curX][curY][curStatus] + 1;
                q.offer(new Node(nextX, nextY, curStatus));
            }

            if (curStatus < K) {
                int nextStatus = curStatus + 1;
                for (int i = 0; i < 8; i++) {
                    int nextX = curX + horseDx[i];
                    int nextY = curY + horseDy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) continue;
                    if (map[nextX][nextY] == 1) continue;
                    if (dist[nextX][nextY][nextStatus] != -1) continue;

                    dist[nextX][nextY][nextStatus] = dist[curX][curY][curStatus] + 1;
                    q.offer(new Node(nextX, nextY, nextStatus));
                }
            }
        }

        return -1;
    }
}
