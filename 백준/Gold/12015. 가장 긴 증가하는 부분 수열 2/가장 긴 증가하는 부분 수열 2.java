import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        int size = 0;
        int[] tails = new int[N];
        for(int i=0; i<N; i++){
            int position = Arrays.binarySearch(tails, 0, size, A[i]);
            if(position < 0) position = -(position + 1);
            tails[position] = A[i];
            if(position == size) size++;
        }

        System.out.println(size);
    }
}
