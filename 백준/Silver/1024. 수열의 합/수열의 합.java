import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for(int l=L; l<=100; l++){
            long tmp = (l * (l - 1)) / 2;
            if (N - tmp < 0) continue;
            if ((N - tmp) % l != 0) continue;

            long x = (N - tmp) / l;

            StringBuilder sb = new StringBuilder();
            for(long i=x; i<x+l; i++) sb.append(i).append(' ');
            System.out.println(sb);
            return;
        }

        System.out.println(-1);

    }
}
