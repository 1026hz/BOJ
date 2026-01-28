import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cardCost = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            cardCost[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = cardCost[1];
        for(int i=2; i<=N; i++){
            for(int j=1; j<i; j++){
                if(dp[i] > dp[j] + dp[i-j]) dp[i] = dp[j] + dp[i-j];
            }
            dp[i] = Math.min(dp[i], cardCost[i]);
        }
        System.out.println(dp[N]);
    }

}

