import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[] relationship;
    static int[] numbers;
    static boolean[] isUsed;
    static boolean find;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        relationship = new char[N];
        numbers = new int[N+1];
        isUsed = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) relationship[i] = st.nextToken().charAt(0);

        find = false;
        solveDesc(0);

        Arrays.fill(numbers, 0);
        Arrays.fill(isUsed,false);
        find = false;
        solveAsc(0);

        System.out.println(sb);
    }


    public static void solveDesc(int nowIdx){

        if(find) return;
        if(nowIdx == N+1){
            for(int i=0; i<=N; i++){
                sb.append(numbers[i]);
            }sb.append('\n');
            find = true;
            return;
        }

        for(int i=9; i>=0; i--){
            if(isUsed[i]) continue;
            if(nowIdx == 0){
                isUsed[i] = true;
                numbers[nowIdx] = i;
                solveDesc(nowIdx + 1);
                isUsed[i] = false;
            } else if(relationship[nowIdx-1] == '<' && numbers[nowIdx-1] < i){
                isUsed[i] = true;
                numbers[nowIdx] = i;
                solveDesc(nowIdx + 1);
                isUsed[i] = false;
            } else if(relationship[nowIdx-1] == '>' && numbers[nowIdx-1] > i){
                isUsed[i] = true;
                numbers[nowIdx] = i;
                solveDesc(nowIdx + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void solveAsc(int nowIdx){

        if(find) return;
        if(nowIdx == N+1){
            for(int i=0; i<=N; i++){
                sb.append(numbers[i]);
            }sb.append('\n');
            find = true;
            return;
        }

        for(int i=0; i<=9; i++){
            if(isUsed[i]) continue;
            if(nowIdx == 0){
                isUsed[i] = true;
                numbers[nowIdx] = i;
                solveAsc(nowIdx + 1);
                isUsed[i] = false;
            } else if(relationship[nowIdx-1] == '<' && numbers[nowIdx-1] < i){
                isUsed[i] = true;
                numbers[nowIdx] = i;
                solveAsc(nowIdx + 1);
                isUsed[i] = false;
            } else if(relationship[nowIdx-1] == '>' && numbers[nowIdx-1] > i){
                isUsed[i] = true;
                numbers[nowIdx] = i;
                solveAsc(nowIdx + 1);
                isUsed[i] = false;
            }
        }
    }
}

