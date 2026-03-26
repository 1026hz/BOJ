import java.io.*;
import java.util.*;

public class Main {

    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node{
        int x, y, w;
        Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for(int x=a; x<c; x++){
                for(int y=b; y<d; y++){
                    map[x][y] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && map[i][j] == 0) {
                    count++;
                    int n = bfs(i,j);
                    list.add(n);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for(int n : list) sb.append(n).append(' ');
        System.out.println(sb);

    }

    static int bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y, 1));
        visited[x][y] = true;
        int count = 1;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int nowX = cur.x;
            int nowY = cur.y;
            int nowW = cur.w;

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(visited[nextX][nextY]) continue;
                if(map[nextX][nextY] == 1) continue;
                visited[nextX][nextY] = true;
                q.offer(new Node(nextX, nextY, nowW+1));
                count++;
            }

        }

        return count;
    }
}