import java.util.*;
public class Vowel_Dictionary {
        static String[] arr;
        static List<String> list;
        public int solution(String word) {
            list = new ArrayList<>();
            arr = new String[]{"A","E","I","O","U"};
            int answer = 0;
            dfs(word,"",0);
            for(int i = 0; i<list.size(); i++){
                if(list.get(i).equals(word)){
                    answer = i;
                }
            }
            return answer;
        }
        public void dfs(String word,String str,int count){
            list.add(str);
            if(count == 5){
                return;
            }
            for(int i = 0; i<arr.length;i++){
                dfs(word,str+arr[i],count+1);
            }
        }
    public static void main(String[] args) {
        Vowel_Dictionary sol = new Vowel_Dictionary();
        System.out.println(sol.solution("AAAE"));
    }
}
