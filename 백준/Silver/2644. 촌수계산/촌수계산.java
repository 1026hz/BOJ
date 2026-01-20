import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int target1, target2;
    static boolean[][] map;
    static int[][] dist;
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        map = new boolean[N+1][N+1];
        dist = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            map[parent][child] = true;
            map[child][parent] = true;
        }
        System.out.println(bfs());

    }

    public static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(map[target1][i]){
                dist[target1][i] = 1;
                dist[i][target1] = 1;
                q.offer(new Node(target1, i));
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            if(curY == target2) return dist[curX][curY];

            for(int i=1; i<=N; i++){
                if(!map[curY][i]) continue;
                else if(dist[curY][i] == 0){
                    dist[curY][i] = dist[curX][curY] + 1;
                    dist[i][curY] = dist[curY][i];
                    q.offer(new Node(curY, i));
                }
            }
        }

        return -1;
    }
}