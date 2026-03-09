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
        for(int num : A){
            int position = Arrays.binarySearch(tails, 0, size, num);
            if(position < 0) position = -(position + 1);
            tails[position] = num;
            if(position == size) size++;
        }
        System.out.println(size);
    }
}
