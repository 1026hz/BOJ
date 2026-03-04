import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] A = new int[N];
        int[] B = new int[N];
        boolean[] visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }
        Arrays.sort(B);

        for(int i=0; i<N; i++){
            int now = B[i];
            for(int j = 0; j <N; j++){
                if(!visited[j] && A[j] == now){
                    visited[j] = true;
                    P[j] = i;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(P[i]).append(' ');

        System.out.println(sb);

    }
}
