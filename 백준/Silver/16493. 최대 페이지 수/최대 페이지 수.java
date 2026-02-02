import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] day = new int[M+1];
        int[] page = new int[M+1];

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            page[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        for(int i=1; i<=M; i++){
            int cost = day[i];
            int value = page[i];
            for(int j = N; j >= cost; j--){
                dp[j] = Math.max(dp[j], dp[j -cost] + value);
            }
        }
        int ans = 0;
        for(int i=1; i<=N; i++) ans = Math.max(ans, dp[i]);
        System.out.println(ans);
    }

}
