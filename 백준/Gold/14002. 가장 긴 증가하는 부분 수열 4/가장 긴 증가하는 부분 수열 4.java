import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] tails = new int[N];
        int[] lastIdx = new int[N];
        int[] parent = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        int size = 0;
        for(int i=0; i<N; i++){
            int x = A[i];
            int position = lowerBound(tails, size, x);
            tails[position] = x;
            lastIdx[position] = i;
            if(position > 0) parent[i] = lastIdx[position-1];
            if(position == size) size++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(size).append('\n');
        int[] ans = new int[N];
        int cur = lastIdx[size - 1];
        for(int i=size-1; i>=0; i--){
            ans[i] = A[cur];
            cur = parent[cur];
        }
        for(int i=0; i<size; i++) sb.append(ans[i]).append(' ');
        System.out.println(sb);

    }

    static int lowerBound(int[] arr, int size, int target){
        int left = 0;
        int right = size;

        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }

        return left;
    }

}
