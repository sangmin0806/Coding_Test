import java.util.*;
public class Truck_Cross_Bridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        int index = 0;
        int sum=0;
        while(true){
            if(index==truck_weights.length)
                break;
            if(que.size()==bridge_length)
                sum-=que.poll();
            if(sum+truck_weights[index]<=weight){
                que.add(truck_weights[index]);
                sum+=truck_weights[index];
                index++;
                answer++;
            }
            else{
                que.add(0);
                answer++;
            }
        }
        return answer + bridge_length;
    }
    public static void main(String[] args) {
        Truck_Cross_Bridge sol = new Truck_Cross_Bridge();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int result = sol.solution(bridge_length,weight,truck_weights);
        System.out.println(result);
    }
}
