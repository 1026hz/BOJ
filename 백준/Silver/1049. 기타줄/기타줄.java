import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minSet = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int set = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            minSet = Math.min(set, minSet);
            minOne = Math.min(one, minOne);
        }
        System.out.println(Math.min((N/6+1)*minSet,Math.min(((N/6)*minSet + (N%6)*minOne), N*minOne)));

    }
}