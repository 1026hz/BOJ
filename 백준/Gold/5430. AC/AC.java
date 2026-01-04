import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String numList = br.readLine();
            if (n == 0 && p.length() == 0){
                sb.append("error").append('\n');
                continue;
            }
            numList = numList.substring(1, numList.length() - 1);
            String[] tokens = numList.split(",");

            Deque<Integer> dq = new ArrayDeque<>();
            if(n > 0){
                for(String token : tokens){
                    dq.add(Integer.parseInt(token));
                }
            }

            boolean errorFlag = false;
            boolean reversedflag = false;

            for(char c : p.toCharArray()){
                n = dq.size();
                if (c == 'R'){
                    if(reversedflag) reversedflag = false;
                    else reversedflag = true;
                } else if (c == 'D'){
                    if(n == 0) errorFlag = true;
                    else if(reversedflag) dq.pollLast();
                    else dq.pollFirst();
                }
            }

            if (errorFlag) sb.append("error").append('\n');
            else {
                sb.append("[");
                if(reversedflag) {
                    for (int l=0; l<dq.size(); l++){
                        sb.append(dq.peekLast()).append(",");
                        dq.addFirst(dq.pollLast());
                    }
                } else {
                    for (int num : dq) {
                        sb.append(num).append(",");
                    }
                }
                if(sb.charAt(sb.length() -1) == ',') sb.deleteCharAt(sb.length() - 1);
                sb.append("]");
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}