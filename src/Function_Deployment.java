import java.util.*;
public class Function_Deployment {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> result = new ArrayList<>();
            int length = progresses.length;
            int[] time = new int[length];
            int deploy = 0;
            Queue<Integer> que = new LinkedList<>();
            for(int i=0; i<length;i++){
                time[i] = (100-progresses[i])/speeds[i];
                if((100-progresses[i])%speeds[i]==0){
                    que.add(time[i]);
                }
                else{
                    que.add(time[i]+1);
                }
            }
            while(!que.isEmpty()){
                int count = 1;
                deploy = que.poll();
                while(!que.isEmpty() && que.peek()<=deploy){
                    que.poll();
                    count++;
                }
                result.add(count);
            }
            int [] answer = new int[result.size()];
            for(int i = 0; i<result.size();i++)
                answer[i]=result.get(i);
            return answer;
        }
    public static void main(String[] args) {
        Function_Deployment sol = new Function_Deployment();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1,1,1,1,1,1};
        int[] result = sol.solution(progresses,speeds);
        System.out.println(Arrays.toString(result));
    }
}

