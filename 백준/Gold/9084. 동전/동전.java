import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] coinValue = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coinValue[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M + 1];
            dp[0] = 1;

            for (int c : coinValue) {
                for (int money = c; money <= M; money++) {
                    dp[money] += dp[money - c];
                }
            }

            sb.append(dp[M]).append('\n');
        }

        System.out.print(sb);
    }
}