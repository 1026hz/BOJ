import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x > 0) {
                pq.add(x);
            }
            else if(x == 0) {
                if (pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            }
        }

        System.out.println(sb);

    }

}
