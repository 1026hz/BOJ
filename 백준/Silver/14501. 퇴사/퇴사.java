import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i일 '아침'에 내가 벌어놓은 최대 돈
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            // 1) 상담 X -> 다음 날 == 오늘 번 돈
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 2) 상담 O -> i + T[i] 로 이동
            int next = i + T[i];
            if (next <= N + 1) {
                dp[next] = Math.max(dp[next], dp[i] + P[i]);
            }
        }

        // N+1일(퇴사일)
        System.out.println(dp[N + 1]);
    }
}
