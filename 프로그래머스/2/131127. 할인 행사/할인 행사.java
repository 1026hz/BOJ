import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        for(int start=0; start<=discount.length-10; start++){
            HashMap<String, Integer> countMap = new HashMap<>();
            for(int i=start; i<start+10; i++){
                if(wantMap.containsKey(discount[i])){
                    countMap.put(discount[i], countMap.getOrDefault(discount[i], 0) + 1);
                }
            }
            boolean flag = true;
            for(String food : wantMap.keySet()){
                if(countMap.getOrDefault(food,0) < wantMap.get(food)) {
                    flag = false;
                    break;
                }
            }   
            if(flag) answer++;
        }
        
        return answer;
    }
}