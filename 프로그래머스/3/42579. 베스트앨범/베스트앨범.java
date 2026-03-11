import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreTotalMap = new HashMap<>();
        Map<String, List<int[]>> genreSongsMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre, 0) + play);
            genreSongsMap.putIfAbsent(genre, new ArrayList<>());
            genreSongsMap.get(genre).add(new int[]{i, play});
        }
        
        List<String> genreList = new ArrayList<>(genreTotalMap.keySet());
        genreList.sort((a, b) -> genreTotalMap.get(b) - genreTotalMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for (String genre : genreList) {
            List<int[]> songs = genreSongsMap.get(genre);
            
            songs.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });
            
            result.add(songs.get(0)[0]);
            if (songs.size() > 1) {
                result.add(songs.get(1)[0]);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}