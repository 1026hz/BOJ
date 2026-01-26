import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = numbers[0];
        int max = numbers[0];

        for(int i=1; i<N; i++) {
            dp[i] = Math.max(dp[i-1] + numbers[i], numbers[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }

}
