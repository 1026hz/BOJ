import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        
        int answer = 0;
        for(String s : babbling){
            s = s.replaceAll("aya", " ");
            s = s.replaceAll("ye", " ");
            s = s.replaceAll("woo", " ");
            s = s.replaceAll("ma", " ");
            
            System.out.println(s);
            s = s.replaceAll(" ", "");
            
            if(s.equals("")) answer+=1;
        }
        return answer;
    }
}