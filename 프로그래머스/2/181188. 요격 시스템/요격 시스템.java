import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] target : targets){
            pq.add(target);
        }
        
        int answer = 0;
        int attack = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] >= attack){
                attack = cur[1];
                answer += 1;
            }
        }

        return answer;
    }
}