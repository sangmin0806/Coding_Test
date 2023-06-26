import java.util.*;
public class H_Index {
        public int solution(int[] citations) {
            int answer = 0;
            int length = citations.length;
            Arrays.sort(citations);
            for(int i = 0; i<length; i++){
                int h = length -i;
                if(citations[i]>=h){
                    answer = h;
                    break;
                }
            }
            return answer;
        }
    public static void main(String[] args) {
        H_Index solutionInstance = new H_Index();
        int[] citations = {3, 30, 34, 5, 9};
        int result = solutionInstance.solution(citations);
        System.out.println("H-Index: " + result);
    }
}
