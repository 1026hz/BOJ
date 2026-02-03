import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] box = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) box[i] = Integer.parseInt(st.nextToken());

        int[] tails = new int[N];
        int size = 0;
        for(int i=0; i<N; i++){
            int position = lowerBound(tails, size, box[i]);
            tails[position] = box[i];
            if(size == position) {
                size++;
            }
        }

        System.out.println(size);
    }

    static int lowerBound(int[] arr, int size, int target){

        int left = 0;
        int right = size;
        while(left < right){
            int mid = (left + right)/2;
            if(arr[mid] >= target) right = mid;
            else left = mid + 1;
        }

        return left;
    }


}
