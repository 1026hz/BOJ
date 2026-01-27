import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = N;
        int y = M;
        while(y != 0){
            int tmp = x % y;
            x = y;
            y = tmp;
        }

        System.out.println(x);
        System.out.println(x*(N/x)*(M/x));

    }

}
