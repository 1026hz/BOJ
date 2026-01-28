import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());

        int INF = Integer.MAX_VALUE;
        int[] dp = new int[K + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : coins) {
            for (int money = coin; money <= K; money++) {
                if (dp[money - coin] != INF) {
                    dp[money] = Math.min(dp[money], dp[money - coin] + 1);
                }
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}