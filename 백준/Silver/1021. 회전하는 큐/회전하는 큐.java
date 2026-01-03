import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        int[] target = new int[M+1];

        for(int i=1; i<=N; i++){
            queue.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

       for(int i=0; i<M; i++){
          //System.out.println(queue + " " + answer + " target: " + target[i]);

           int targetIndex = 0;

           for(int n : queue){
               if (n == target[i]) break;
               targetIndex++;
           }

           int left = targetIndex;
           int right = queue.size() - targetIndex + 1;

           if(!queue.isEmpty() && queue.peekFirst() == target[i]){
              //System.out.println("동일");
               queue.pollFirst();
               continue;
           } else if (left < right){
               //System.out.println("left");
               while(!queue.isEmpty() && queue.peekFirst() != target[i]){
                   queue.addLast(queue.pollFirst());
                   answer++;
               }
           } else if (left >= right){
               //System.out.println("right");
               while(!queue.isEmpty() && queue.peekFirst() != target[i]) {
                   queue.addFirst(queue.pollLast());
                   answer++;
               }
           }
           queue.pollFirst();
       }

       System.out.println(answer);

    }
}