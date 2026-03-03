import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lan = new int[K];
        for(int i=0; i<K; i++){
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        long ans = 0;
        long left = 1;
        long right = lan[K-1];

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for(int i=0; i<K; i++){
                count += lan[i]/mid;
            }
            if(count >= N) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }
}
