import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(3, N + 1)];
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3; i<=N; i++){
            dp[i] = dp[i-1]%10007 + dp[i-2]%10007 + dp[i-2]%10007;
        }
        System.out.println(dp[N]%10007);

    }

}
