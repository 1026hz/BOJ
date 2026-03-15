import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        long ans = 0;
        for(int i=1; i<N; i++){
            ans += (N * i + i);
        }

        System.out.println(ans);

    }
}
