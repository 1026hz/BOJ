import java.io.*;
import java.util.*;

public class Main {

    static int W;
    static int H;
    static char[][] map;
    static int[][] fire;
    static int[][] person;
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            fire = new int[H][W];
            person = new int[H][W];

            for (int h = 0; h < H; h++) {
                Arrays.fill(fire[h], -1);
                Arrays.fill(person[h], -1);
            }

            for (int h = 0; h < H; h++) {
                String s = br.readLine();
                for (int w = 0; w < W; w++) {
                    char now = s.charAt(w);
                    if (now == '@')
                        person[h][w] = 0;
                    else if (now == '*')
                        fire[h][w] = 0;
                    else
                        map[h][w] = now;
                }
            }

            fireBfs();
            int time = personBfs();
            if (time == -1)
                sb.append("IMPOSSIBLE").append('\n');
            else {
                sb.append(time).append('\n');
            }
        }
        System.out.println(sb);
    }


    public static void fireBfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int h=0; h<H; h++){
            for(int w=0; w<W; w++) {
                if(fire[h][w] == 0) q.offer(new Node(h,w));
            }
        }
        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) continue;
                if(map[nextX][nextY] == '#') continue;
                if(fire[nextX][nextY] != -1) continue;
                fire[nextX][nextY] = fire[curX][curY] + 1;
                q.offer(new Node(nextX, nextY));
            }
        }
    }

    public static int personBfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int h=0; h<H; h++){
            for(int w=0; w<W; w++) {
                if(person[h][w] == 0) q.offer(new Node(h,w));
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            for(int i=0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) return person[curX][curY] + 1;
                if(map[nextX][nextY] == '#') continue;
                if(person[nextX][nextY] != -1) continue;
                if(fire[nextX][nextY] != -1 && fire[nextX][nextY] <= person[curX][curY] + 1) continue;
                person[nextX][nextY] = person[curX][curY] + 1;
                q.offer(new Node(nextX, nextY));
            }
        }

        return -1;
    }

}
