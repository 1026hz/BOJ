import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int x, y;
        Node(int x ,int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, ans1, ans2;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N+1][N+1];
        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=1; j<=N; j++){
                graph[i][j] = s.charAt(j-1);
            }
        }

        // 적록색약이 아닌 사람
        visited = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(!visited[i][j]) {
                    bfs(i, j, false);
                    ans1++;
                }
            }
        }

        // 적록색약인 사람
        visited = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(!visited[i][j]) {
                    bfs(i, j, true);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);


    }

    static void bfs(int x, int y, boolean isDiff){
        Queue<Node> q = new ArrayDeque<>();
        char color = graph[x][y];
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int nowX = cur.x;
            int nowY = cur.y;
            for(int i=0; i<4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(nextX <= 0 || nextY <= 0 || nextX > N || nextY > N) continue;
                if(visited[nextX][nextY]) continue;
                if(!isDiff){
                    if(graph[nextX][nextY] != color) continue;
                } else{
                    if(graph[nextX][nextY] == 'R' && color == 'B') continue;
                    else if(graph[nextX][nextY] == 'G' && color == 'B') continue;
                    else if(graph[nextX][nextY] == 'B' && color == 'R') continue;
                    else if(graph[nextX][nextY] == 'B' && color == 'G') continue;
                }

                q.offer(new Node(nextX, nextY));
                visited[nextX][nextY] = true;
            }

        }
    }

}
