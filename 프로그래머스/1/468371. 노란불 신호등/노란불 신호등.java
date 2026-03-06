class Solution {
    public int solution(int[][] signals) {
        
        int lcmAll = 1;
        
        for(int[] signal : signals){
            int green = signal[0];
            int yellow = signal[1];
            int red = signal[2];
            int period = green + yellow + red;
            lcmAll = lcm(lcmAll, period);
        }
        
        for(int i=1; i<=lcmAll; i++){
            
            boolean allYellow = true;
            
            for(int[] signal : signals){
                int green = signal[0];
                int yellow = signal[1];
                int red = signal[2];
                int period = green + yellow + red;
                
                int position = (i - 1) % period;
                
                if(!(green <= position && position < green + yellow)){
                    allYellow = false;
                    continue;
                }
            }
            
            if(allYellow) return i;
        }
        return -1;
    }
    
    static int lcm(int a ,int b){
        return (a * b) / gcd(a, b);
    }
    
    static int gcd(int a, int b){
        if(b== 0) return a;
        else return gcd(b, a % b);
    }
}