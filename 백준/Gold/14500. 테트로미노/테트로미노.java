import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int max = 0;
    static int[][] map;
    static int[] dx = {1, -1 ,0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i, j ,1, map[i][j]);
                visited[i][j] = false;
                checkT(i, j, map[i][j]);
            }
        }

        System.out.println(max);
    }
    static void dfs(int x, int y, int count, int sum){

        if(count == 4) {
            max = Math.max(sum, max);
            return;
        }

        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
            if(visited[nextX][nextY]) continue;
            visited[nextX][nextY] = true;
            dfs(nextX, nextY, count+1, sum + map[nextX][nextY]);
            visited[nextX][nextY] = false;
        }

    }

    static void checkT(int x, int y, int sum){
        // ㅓ
        if (y-1 >= 0 && x-1 >= 0 && x+1 < N){
            int tmp = sum + (map[x][y-1] + map[x-1][y] + map[x+1][y]);
            max = Math.max(tmp, max);
        }

        // ㅏ
        if (x-1 >= 0 && x+1 < N && y+1 < M){
            int tmp = sum + (map[x-1][y] + map[x][y+1] + map[x+1][y]);
            max = Math.max(tmp, max);
        }

        // ㅗ
        if (x-1 >= 0 && y-1 >= 0 && y+1 < M){
            int tmp = sum + (map[x][y-1] + map[x-1][y] + map[x][y+1]);
            max = Math.max(tmp, max);
        }

        // ㅜ
        if (y-1 >= 0 && y+1 < M && x+1 < N){
            int tmp = sum + (map[x][y-1] + map[x][y+1] + map[x+1][y]);
            max = Math.max(tmp, max);
        }
    }
}