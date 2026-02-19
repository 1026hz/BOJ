import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] numbers = new int[N][N];
        int[][] dp = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = numbers[0][0];
        for(int i=1; i<N; i++){
            for(int j=0; j<=i; j++){
                if(dp[i][j] == 0 && j == 0) dp[i][j] = dp[i-1][j] + numbers[i][j];
                else if(dp[i][j] == 0 && i == j) dp[i][j] = dp[i-1][j-1] + numbers[i][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                    dp[i][j] += numbers[i][j];
                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) if(max < dp[N-1][i]) max = dp[N-1][i];

        System.out.println(max);



    }
}
