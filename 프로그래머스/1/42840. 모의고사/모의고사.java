import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        int maxScore = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == first[i % first.length]) {
                firstScore += 1;
                if(maxScore < firstScore) maxScore = firstScore;
            }
            if(answers[i] == second[i % second.length]) {
                secondScore += 1;
                if(maxScore < secondScore) maxScore = secondScore;
            }
            if(answers[i] == third[i % third.length]) {
                thirdScore += 1;
                if(maxScore < thirdScore) maxScore = thirdScore;
            }
        }
        
        //System.out.println(firstScore + " " + secondScore + " " + thirdScore);
        
        List<Integer> arrList = new ArrayList<>();
        if(maxScore == firstScore) arrList.add(1);
        if(maxScore == secondScore) arrList.add(2);
        if(maxScore == thirdScore) arrList.add(3);
                
        int[] answer = new int[arrList.size()];
        for(int i=0; i<arrList.size(); i++){
            answer[i] = arrList.get(i);
        }
        
        return answer;
    }
}