import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N + 1];
        arr = new int[M + 1];
        isUsed = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        solve(1);
        System.out.println(sb);
    }

    static void solve(int nowIdx){

        if(nowIdx == M+1){
            for(int i=1; i<=M; i++) {
                sb.append(num[arr[i]]).append(' ');
            }sb.append('\n');
            return;
        }

        for(int i=1; i<=N; i++){
            if(!isUsed[i] && arr[nowIdx-1]<i){
                isUsed[i] = true;
                arr[nowIdx] = i;
                solve(nowIdx + 1);
                isUsed[i] = false;
            }
        }
    }
}
