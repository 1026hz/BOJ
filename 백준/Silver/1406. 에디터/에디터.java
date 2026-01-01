import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        LinkedList<Character> wordList = new LinkedList<>();
        for(char c : word.toCharArray()) {
            wordList.add(c);
        }
        ListIterator<Character> cursor = wordList.listIterator(wordList.size());

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("L")){
                if (cursor.hasPrevious()) cursor.previous();
            } else if (command.equals("D")){
                if (cursor.hasNext()) cursor.next();
            } else if (command.equals("B")){
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else if (command.equals("P")){
                char addChar = st.nextToken().charAt(0);
                cursor.add(addChar);
            }
        }

        StringBuilder sb = new StringBuilder(wordList.size());
        for (char c : wordList) sb.append(c);
        System.out.print(sb);

    }
}