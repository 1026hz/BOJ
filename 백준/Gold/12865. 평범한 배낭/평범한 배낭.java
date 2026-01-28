import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weight = new int[N+1];
        int[] value = new int[N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[][] profit = new int[K+1][N+1];
        for(int i=1; i<=K; i++){
            for(int j=1; j<=N; j++){
                int curWeight = weight[j];
                int curValue = value[j];
                if(weight[j] > i) profit[i][j] = profit[i][j-1];
                else{
                    profit[i][j] = Math.max(curValue + profit[i-curWeight][j-1], profit[i][j-1]);
                }
            }
        }

        System.out.println(profit[K][N]);
    }

}

