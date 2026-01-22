import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];
        isUsed = new boolean[N+1];
        solve(1, 1);
        System.out.println(sb);
    }
    static void solve(int now, int nowNum){

        isUsed[nowNum] = false;

        if(now == M+1){
            for(int i=1; i<=M; i++){
                sb.append(arr[i]).append(' ');
            }sb.append('\n');
            return;
        }

        for(int i=1; i<=N; i++){
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[now] = i;
                solve(now + 1, i);
                isUsed[i] = false;
            }
        }
    }

}
