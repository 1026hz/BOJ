import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        String ans = "";

        for(int i=2; i>=0; i--){
            if(s1.charAt(i) > s2.charAt(i)) {
                ans = s1;
                break;
            }
            else if (s1.charAt(i) < s2.charAt(i)) {
                ans = s2;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2; i>=0; i--){
            sb.append(ans.charAt(i));
        }
        System.out.println(sb);


    }
}
