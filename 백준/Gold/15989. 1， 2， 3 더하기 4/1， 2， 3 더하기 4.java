import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N+1];
            dp[0] = 1;
            for(int i=1; i<=3; i++){
                for(int j=1; j<=N; j++){
                    if(j >= i) dp[j] += dp[j-i];
                }
            }
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb);
    }
}