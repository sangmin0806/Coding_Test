import java.util.*;
public class Process {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Integer> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();
            PriorityQueue<Integer> sortedQueue = new PriorityQueue<>( Comparator.reverseOrder());
            for(int i = 0; i<priorities.length;i++){
                queue1.add(priorities[i]);
                queue2.add(i);
                sortedQueue.add(priorities[i]);
            }
            while(!queue1.isEmpty()){
                int k = queue1.poll();
                int index = queue2.poll();
                if(k==sortedQueue.peek()){
                    sortedQueue.poll();
                    answer++;
                    if(index == location){
                        return answer;
                    }
                }
                else{
                    queue1.add(k);
                    queue2.add(index);
                }
            }
            return answer;
        }
    public static void main(String[] args) {
        Process sol = new Process();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int result = sol.solution(priorities,location);
        System.out.println(result);
    }
}


