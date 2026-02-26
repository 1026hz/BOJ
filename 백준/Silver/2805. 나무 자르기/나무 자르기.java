import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        for(int i=0; i<N; i++) tree[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(tree);

        long left = 0;
        long right = tree[N-1];
        long ans = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            long sum = 0;
            for(int height : tree){
                if (height > mid) sum += (height - mid);
            }

            if(sum >= M){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

}
