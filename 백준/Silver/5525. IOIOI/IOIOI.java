import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append("I");
        for(int i=0; i<N; i++) sb.append("OI");
        String P = sb.toString();

        int idx = 0;
        int count = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == P.charAt(idx)){
                //System.out.println("same : " + i + " " + P.charAt(idx));
                idx++;
                if(idx == P.length()){
                    count++;
                    idx = 0;
                    i-=P.length()-2;
                }
            } else{
                idx = 0;
                if(S.charAt(i) == P.charAt(idx)){
                    idx++;
                }
            }
        }

        System.out.println(count);


    }

}
