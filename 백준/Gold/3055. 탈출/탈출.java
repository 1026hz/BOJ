import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static int[][] water;
    static int[][] hedgehog;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node{
        int x, y;
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
        water = new int[R][C];
        hedgehog = new int[R][C];

        for(int i=0; i<R; i++){
            Arrays.fill(water[i], -1);
            Arrays.fill(hedgehog[i], -1);
        }

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
            }
        }

        waterBfs();
        int ans = hedgehogBfs();
        if (ans == -1) System.out.println("KAKTUS");
        else System.out.println(ans);

    }

    public static void waterBfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == '*') {
                    q.offer(new Node(i, j));
                    water[i][j] = 0;
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

                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                // 이미 방문했을 경우
                if(water[nextX][nextY] != -1) continue;
                // 못 가는 길일 경우 (
                if(map[nextX][nextY] == 'D' || map[nextX][nextY] == 'X') continue;
                water[nextX][nextY] = water[curX][curY] + 1;
                q.offer(new Node(nextX, nextY));
            }
        }
    }

    public static int hedgehogBfs(){
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 'S') {
                    q.offer(new Node(i, j));
                    hedgehog[i][j] = 0;
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

                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;

                // 비버 집 방문하면
                if(map[nextX][nextY] == 'D') return hedgehog[curX][curY] + 1;
                // 이미 방문했을 경우
                if(hedgehog[nextX][nextY] != -1) continue;
                // 못 가는 경로(돌, 다음 시간 혹은 그 이전에 물이 차면)일 경우
                if(map[nextX][nextY] == 'X' || (water[nextX][nextY] != -1 && water[nextX][nextY] <= hedgehog[curX][curY] + 1)) continue;
                hedgehog[nextX][nextY] = hedgehog[curX][curY] + 1;
                q.offer(new Node(nextX, nextY));
            }
        }

        return -1;
    }

}