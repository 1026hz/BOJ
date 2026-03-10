import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] c : clothes){
            if(map.containsKey(c[1])){
                int now = map.get(c[1]);
                map.put(c[1], now + 1);
            } else{
                map.put(c[1], 2);
            }
        }
        
        int cal = 1;
        for(String s : map.keySet()){
            cal *= map.get(s);
        }
    
        return cal - 1;
    }
}