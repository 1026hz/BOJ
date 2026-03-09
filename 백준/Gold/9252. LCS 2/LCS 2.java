import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S1 = br.readLine();
        String S2 = br.readLine();
        int[][] dp = new int[S1.length()+1][S2.length()+1];

        for(int i=1; i<=S1.length(); i++){
            for(int j=1; j<=S2.length(); j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int idx1 = S1.length();
        int idx2 = S2.length();
        List<Character> ans = new ArrayList<>();

        while(idx1 > 0 && idx2 > 0){
            if(S1.charAt(idx1-1) == S2.charAt(idx2-1)){
                ans.add(S1.charAt(idx1-1));
                idx1 -=1;
                idx2 -=1;
            } else{
                if(dp[idx1-1][idx2] >= dp[idx1][idx2-1]) idx1 -=1;
                else idx2 -=1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for(int i=ans.size()-1; i>=0; i--) sb.append(ans.get(i));
        System.out.println(sb);

    }
}
