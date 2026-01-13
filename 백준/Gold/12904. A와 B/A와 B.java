import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        boolean reverse = false;

        while(T.length() > S.length()){
            char last;
            if(!reverse) last = T.charAt(T.length() - 1);
            else last = T.charAt(0);

            if(last == 'A'){
                if(!reverse) T = T.substring(0, T.length()-1);
                else T = T.substring(1, T.length());
            } else{
                if(!reverse){
                    T = T.substring(0, T.length() - 1);
                    reverse = true;
                }else{
                    T = T.substring(1, T.length());
                    reverse = false;
                }
            }
        }

        if(reverse) {
            StringBuilder sb = new StringBuilder(T);
            T = sb.reverse().toString();
        }

        if (T.equals(S)) System.out.println(1);
        else System.out.println(0);

    }
}
