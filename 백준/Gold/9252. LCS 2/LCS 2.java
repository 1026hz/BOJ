import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int N = s1.length();
        int M = s2.length();
        int[][] dp = new int[N + 1][M + 1];
        int[][][] parent = new int[N+1][M+1][2];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    parent[i][j][0] = i-1;
                    parent[i][j][1] = j-1;
                } else{
                    if(dp[i-1][j] >= dp[i][j-1]){
                        dp[i][j] = dp[i-1][j];
                        parent[i][j][0] = i-1;
                        parent[i][j][1] = j;
                    }
                    else{
                        dp[i][j] = dp[i][j-1];
                        parent[i][j][0] = i;
                        parent[i][j][1] = j-1;
                    }
                }
            }
        }
        int size = dp[N][M];
        List<Character> ans = new ArrayList<>();
        int curX = N;
        int curY = M;

        while(curX > 0 && curY > 0){
            int nextX = parent[curX][curY][0];
            int nextY = parent[curX][curY][1];

            if(curX -1 == nextX && curY - 1 == nextY) ans.add(s1.charAt(curX-1));

            curX = nextX;
            curY = nextY;
        }

        Collections.reverse(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(size).append('\n');
        for(char c : ans) sb.append(c);

        System.out.println(sb);

    }
}
