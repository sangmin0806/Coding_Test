import java.util.*;
public class I_Hate_Same_Number {
        public int[] solution(int []arr) {
            Queue<Integer> que = new LinkedList<Integer>();
            que.add(arr[0]);
            for(int i = 1; i<arr.length; i++){
                if(arr[i] != arr[i-1])
                    que.add(arr[i]);
            }
            int[] answer = new int[que.size()];
            int size = que.size();
            for(int i = 0;i<size;i++){
                answer[i] = que.poll();
            }
            return answer;
        }

    public static void main(String[] args) {
        I_Hate_Same_Number sol = new I_Hate_Same_Number();
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(sol.solution(arr));
    }
}
