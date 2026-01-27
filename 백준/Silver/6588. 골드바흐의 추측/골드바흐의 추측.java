import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for(int i=1; i*i<=1000000; i++){
            if(!isPrime[i]) continue;
            for(int j=i*i; j<=1000000; j+=i){
                isPrime[j] = false;
            }
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                System.out.println(sb);
                return;
            }

            for(int i=3; i<=n; i++){
                if(isPrime[i] && isPrime[n-i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append('\n');
                    break;
                }
                if(i==n) sb.append("Goldbach's conjecture is wrong.");
            }

        }

    }
}
