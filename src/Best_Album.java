import java.util.*;

public class Best_Album {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<Integer,String> map = new HashMap<>();
        List<String> genlist = new ArrayList<>();
        int length = genres.length;
        for(int i = 0; i<length;i++){
            int num =0;//장르별 plays수 담기
            if(map.containsValue(genres[i]))
                continue;
            for(int j = 0; j<length; j++){
                if(genres[i].equals(genres[j])){
                    num +=plays[j];
                }
            }
            map.put(num,genres[i]);
        }

        while(!map.isEmpty()){
            int max = 0;
            for(int key: map.keySet()){
                if(max<key){
                    max = key;
                }
            }
            genlist.add(map.get(max));
            map.remove(max);
        }


        List<int[]> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i =0; i<genlist.size(); i++){
            for(int j =0; j<length;j++){
                if(genlist.get(i).equals(genres[j])){
                    list.add(new int[]{j,plays[j]});
                }
            }
            Collections.sort(list, (o1, o2) -> Integer.compare(o2[1], o1[1]));
            if(list.size()==1)
                result.add(list.get(0)[0]);
            else{
                for(int k = 0; k<2; k++){
                    result.add(list.get(k)[0]);
                }
            }
            list.clear();
        }

        int[] answer = new int[result.size()]; // answer 배열 생성

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i); // result 리스트의 값들을 answer 배열에 전달
        }
        return answer;
    }
    public static void main(String[] args) {
        Best_Album sol = new Best_Album();
        String[] genres = {"classic", "classic", "classic", "classic", "pop"};
        int[] plays = {400, 600, 500, 500, 2500};
        int[] result = sol.solution(genres,plays);
        System.out.println(Arrays.toString(result));
    }
}
