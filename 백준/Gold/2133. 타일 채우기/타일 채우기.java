import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        if(N>=2) dp[2] = 3;
        if(N>=4) dp[4] = 11;
        for(int i=6; i<=N; i++){
            if(i%2==0) {
                dp[i] = dp[i - 2] * 3; // dp[2] 모양을 붙인 것
                for(int j=i-2; j>=4; j-=2){
                    dp[i] += dp[i - j] * 2; // 특수모양 두개에 대한 걸 모두 더해 줌
                }
                dp[i] += 2; // 새로운 특수모양 두개
            }

        }
        System.out.println(dp[N]);

    }

}

