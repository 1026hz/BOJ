import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] request = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            request[i] = Integer.parseInt(st.nextToken());
        }
        long M = Integer.parseInt(br.readLine());

        Arrays.sort(request);

        long left = 0;
        long right = request[N-1];
        long ans = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            int sum = 0;
            for(int i=0; i<N; i++){
                if(mid >= request[i]) sum += request[i];
                else sum += mid;
            }
            if(sum <= M) {
                ans = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }
}
