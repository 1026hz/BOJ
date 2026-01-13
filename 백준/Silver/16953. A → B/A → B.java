import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int ans = 0;

        while(b.length() >= a.length()){
            if(a.equals(b)){
                System.out.println(ans + 1);
                return;
            }
            ans++;
            if(b.charAt(b.length() - 1) == '1'){
                b = b.substring(0, b.length() - 1);
            } else{
                long numB = Long.parseLong(b);
                if(numB % 2 == 1){
                    System.out.println(-1);
                    return;
                }
                numB /= 2;
                b = Long.toString(numB);
            }
        }

        System.out.println(-1);

    }
}
