import java.io.*;
import java.util.*;

public class Main {

    static class Reservation implements Comparable<Reservation>{
        int start, end;
        Reservation(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Reservation r){
            if (this.end != r.end) return Integer.compare(this.end, r.end);
            return Integer.compare(this.start, r.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Reservation[] reservations = new Reservation[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            reservations[i] = new Reservation(s, e);
        }

        Arrays.sort(reservations);

        int preEnd = 0;
        int count = 0;
        for(Reservation r : reservations){
            if( r.start >= preEnd ){
                count++;
                preEnd = r.end;
            }
        }

        System.out.println(count);

    }

}