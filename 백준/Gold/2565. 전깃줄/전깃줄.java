import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[501];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            line[n] = m;
        }
        int[] tails = new int[501];
        int size = 0;
        for(int i=1; i<=500; i++){
            if(line[i] == 0) continue;
            int position = lowerBound(tails, size, line[i]);
            tails[position] = line[i];
            if(position == size) size++;

            StringBuilder sb = new StringBuilder();
            for(int x : tails) sb.append(x);
        }
        System.out.println(N-size);
    }

    static int lowerBound(int[] arr, int size, int target){
        int left = 0;
        int right = size;
        while (left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

}
