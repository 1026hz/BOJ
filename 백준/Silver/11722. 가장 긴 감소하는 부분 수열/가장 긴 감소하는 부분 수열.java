import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] tails = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        int size = 0;
        for(int x : A){
            int position = upperBound(tails, size, x);
            tails[position] = x;
            if(position == size) size++;
        }
        
        System.out.println(size);
    }

    static int upperBound(int[] arr, int size, int target){
        int left = 0;
        int right = size;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] <= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

}
