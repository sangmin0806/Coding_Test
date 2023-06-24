import java.util.*;
public class Clothes {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String,String> map1 = new HashMap<>();
            HashMap<String,String> map2 = new HashMap<>();
            int count = 0;
            for(String[] s : clothes)
                map1.put(s[1],s[0]);

            for(String k: map1.keySet()){
                for(String[] j: clothes){
                    if(k.equals(j[1]))
                        count++;
                }
                answer *= (count+1);
                count = 0;
            }

            return answer-1;
        }
    public static void main(String[] args) {
        Clothes solutionInstance = new Clothes();

        String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};


        int result = solutionInstance.solution(clothes);
        System.out.println("the number of combinations of different clothes: " + result);
    }
}
