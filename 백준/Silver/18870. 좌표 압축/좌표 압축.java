import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] sortedNumbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
            sortedNumbers[i] = num;
        }

        Arrays.sort(sortedNumbers);
        HashMap<Integer, Integer> uniqueMap = new HashMap<>();
        int idx = 0;
        for(int i=0; i<N; i++) {
            if(!uniqueMap.containsKey(sortedNumbers[i]))
                uniqueMap.put(sortedNumbers[i], idx++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int number = numbers[i];
            int ans = uniqueMap.get(number);
            sb.append(ans).append(' ');
        }

        System.out.println(sb);

    }
}
