import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int moneyJ = Integer.parseInt(br.readLine());
        int haveJ = 0;
        int moneyS = moneyJ;
        int haveS = 0;
        int[] day = new int[15];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=14; i++){
            day[i] = Integer.parseInt(st.nextToken());
        }

        int today = 1;
        while(today <= 14){
            if(moneyJ >= day[today]) {
                int tmp = moneyJ / day[today];
                moneyJ = moneyJ % day[today];
                haveJ += tmp;
            }
            if(today>=4){
                if((day[today-3] < day[today-2]) && (day[today-2] < day[today-1])){
                    moneyS += (haveS * day[today]);
                    haveS = 0;
                }else if((day[today-3] > day[today-2]) && (day[today-2] > day[today-1])){
                    int tmp = moneyS / day[today];
                    moneyS = moneyS % day[today];
                    haveS += tmp;
                }
            }
            today++;
        }

        if(moneyJ + haveJ * day[14] > moneyS + haveS * day[14]) System.out.println("BNP");
        else if(moneyJ + haveJ * day[14] < moneyS + haveS * day[14]) System.out.println("TIMING");
        else System.out.println("SAMESAME");

    }
}
