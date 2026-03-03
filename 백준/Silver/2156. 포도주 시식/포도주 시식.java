import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] drink = new int[N+1];
        for(int i=1; i<=N; i++) drink[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][3];
        dp[1][0] = drink[1]; // 이전꺼랑 이번꺼 마심
        dp[1][1] = drink[1]; // 이전꺼 안 마시고 이번꺼만 마심
        dp[1][2] = 0; // 안 마심

        for(int i=2; i<=N; i++){
            dp[i][0] = dp[i-1][1] + drink[i];
            dp[i][1] = dp[i-1][2] + drink[i];
            dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
        }

        int max = 0;
        for(int i=0; i<3; i++) {
            if (max < dp[N][i]) max = dp[N][i];

        }
        System.out.println(max);
    }
}
