import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] health = new int[N+1];
        int[] joy = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) health[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) joy[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[100];

        for(int i=1; i<=N; i++) {
            int cost = health[i];
            int value = joy[i];
            for (int j = 99; j >= cost; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost] + value);
            }
        }

        int ans = 0;
        for(int i=0; i<=99; i++) ans = Math.max(ans, dp[i]);

        System.out.println(ans);

    }

}
