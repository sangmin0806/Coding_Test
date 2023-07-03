import java.util.Arrays;

public class Stock_Price {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i<prices.length;i++){
            for(int j = i+1; j<prices.length; j++){
                if(prices[i]<=prices[j])
                    answer[i]++;
                else{
                    answer[i]++;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Stock_Price sol = new Stock_Price();
        int[] prices = {1,2,3,2,3};
        int[] result = sol.solution(prices);
        System.out.println(Arrays.toString(result));
    }
}
