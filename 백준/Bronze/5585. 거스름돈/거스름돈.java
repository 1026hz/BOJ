import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5, 1};

        int idx = 0;
        int count = 0;
        while(N > 0){
            if(N >= coins[idx]){
                count += N/coins[idx];
                N %= coins[idx];
            } else idx++;
        }

        System.out.println(count);
    }

}