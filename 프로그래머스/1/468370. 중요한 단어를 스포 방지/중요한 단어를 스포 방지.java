import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        
        int N = message.length();
        Set<String> ans = new HashSet<>();
        Set<String> notAns = new HashSet<>();
        boolean[] isSpoiler = new boolean[N];
        
        for(int[] range : spoiler_ranges){
            for(int i=range[0]; i<=range[1]; i++){
                isSpoiler[i] = true;
            }
        }
        
        StringTokenizer st = new StringTokenizer(message);
        
        int i = 0;
        while(i < N){
            
            if(message.charAt(i) == ' ') {
                i++;
                continue;
            }
            
            int start = i;
            boolean isImportant = false;
            
            while(i < N && message.charAt(i) != ' '){
                if(isSpoiler[i]){
                    isImportant = true;
                }
                i++;
            }
            
            String word = message.substring(start, i);
            
            if(isImportant){
                if(!notAns.contains(word)) ans.add(word);
            } else{
                notAns.add(word);
                if(ans.contains(word)) ans.remove(word);
            }
        
        }
        
        int answer = ans.size();
        return answer;
    }
}