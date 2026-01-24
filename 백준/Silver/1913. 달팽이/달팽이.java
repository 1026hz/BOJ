import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];

        int num = N*N;
        int x = 1;
        int y = 1;
        String status = "down";
        while(num > 0){
            map[x][y] = num;
            if(status == "down"){
                if(x + 1 > N || map[x+1][y] != 0) {
                    status = "right";
                    y++;
                }
                else x++;
            } else if(status == "right"){
                if(y + 1 > N || map[x][y+1] != 0){
                    status = "up";
                    x--;
                }
                else y++;
            } else if(status == "up"){
                if(x - 1 == 0 || map[x-1][y] != 0){
                    status = "left";
                    y--;
                }
                else x--;
            } else if(status == "left"){
                if(y - 1 == 0 || map[x][y-1] != 0){
                    status = "down";
                    x++;
                }
                else y--;
            }
            num--;
        }
        int ansX = 0, ansY = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                sb.append(map[i][j]).append(' ');
                if(map[i][j] == target){
                    ansX = i;
                    ansY = j;
                }
            }sb.append('\n');
        }

        sb.append(ansX).append(' ').append(ansY);
        System.out.println(sb);
    }
}
