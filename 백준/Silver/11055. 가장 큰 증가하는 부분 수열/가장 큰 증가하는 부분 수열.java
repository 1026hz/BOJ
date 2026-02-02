import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            dp[i] = A[i];
            for(int j=0; j<i; j++){
                if(A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j] + A[i]);
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++) if(ans < dp[i]) ans = dp[i];
        System.out.println(ans);
    }


}
