import java.util.*;
public class K_Number {
        public int[] solution(int[] array, int[][] commands) {
            int length = commands.length;
            int[] answer = new int[length];
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                for (int j = commands[i][0]; j <= commands[i][1]; j++)
                    list.add(array[j - 1]);
                Collections.sort(list);
                answer[i] = list.get(commands[i][2] - 1);
                list.clear();
            }
            return answer;
        }
    public static void main(String[] args) {
        K_Number solutionInstance = new K_Number();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = solutionInstance.solution(array, commands);
        for(int i  = 0; i < result.length; i++)
            System.out.println("The k-th number after sorting the elements of the array from the i-th position to the j-th position is: " + result[i]);
    }
}