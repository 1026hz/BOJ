import java.io.*;
import java.util.*;

public class Main {

    static int R;
    static int C;
    static char[][] map;
    static int[][] fire;
    static int[][] person;
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, 1, -1};
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fire = new int[R][C];
        person = new int[R][C];
        for(int i=0; i<R; i++){
            Arrays.fill(fire[i],-1);
            Arrays.fill(person[i], -1);
        }


        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'J')  person[i][j] = 0;
                else if (s.charAt(j) == 'F')  fire[i][j] = 0;
                map[i][j] = s.charAt(j);
            }
        }
        fireBfs();
        int time = personBfs();

        if(time == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(time);


    }

    public static void fireBfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(fire[i][j] == 0) q.offer(new Node(i,j));
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                if(fire[nextX][nextY] != -1) continue;
                if(map[nextX][nextY] == '.'){
                    fire[nextX][nextY] = fire[curX][curY] + 1;
                    q.offer(new Node(nextX, nextY));
                }
            }
        }

    }

    public static int personBfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(person[i][j] == 0) q.offer(new Node(i,j));
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curTime = person[curX][curY];

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) return curTime+1;
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
