import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String numbers = br.readLine();
            numbers = numbers.substring(1, numbers.length() - 1);
            String[] numList = (n == 0) ? new String[0] : numbers.split(",");

            boolean reverse = false;
            boolean error = false;

            int start = 0;
            int end = n - 1;

            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else {
                    if (start > end) {
                        error = true;
                        break;
                    }
                    if (reverse) end--;
                    else start++;
                }
            }

            if (error) {
                sb.append("error\n");
                continue;
            }

            // 남은 구간 출력
            sb.append('[');
            if (start <= end) {
                if (!reverse) {
                    for (int i = start; i <= end; i++) {
                        if (i > start) sb.append(',');
                        sb.append(numList[i]);
                    }
                } else {
                    for (int i = end; i >= start; i--) {
                        if (i < end) sb.append(',');
                        sb.append(numList[i]);
                    }
                }
            }
            sb.append("]\n");
        }

        System.out.print(sb);
    }
}
