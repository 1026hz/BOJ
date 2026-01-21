import java.io.*;
import java.util.*;

public class Main {
    static char[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null) {
            int size = (int)Math.pow(3, Integer.parseInt(input));
            ans = new char[size +1];
            Arrays.fill(ans, '-');
            solve(1, size);
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i<= size; i++) sb.append(ans[i]);
            System.out.println(sb);
        }
    }

    static void solve(int x, int size){
        if(size == 0) return;
        // 공백 만들기
        for(int i = x+(size/3); i < x+(size/3)*2; i++) ans[i] = ' ';
        // 다음 호출
        int nextSize = size/3;
        solve(x, nextSize);
        solve(x + (nextSize) * 2, nextSize);
    }

}
