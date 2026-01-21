import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        long[][] A = new long[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] ans = pow(A, B);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(ans[i][j]).append(' ');
            }sb.append('\n');
        }

        System.out.println(sb);
    }

    static long[][] pow(long[][] A, long exp){
        if(exp == 1){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    A[i][j] %= 1000;
                }
            }
            return A;
        }

        long[][] half = pow(A, exp/2);
        long[][] result = mul(half, half);

        if(exp % 2 == 1){
            result = mul(result, A);
        }

        return result;
    }

    static long[][] mul(long[][] X, long[][] Y){
        long[][] result = new long[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                long sum = 0;
                for(int k=0; k<N; k++){
                    sum += (X[i][k] * Y[k][j]) % 1000;
                }
            result[i][j] = sum % 1000;
            }
        }

        return result;
    }
}
