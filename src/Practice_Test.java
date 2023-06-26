import java.util.*;
public class Practice_Test {
        public int[] solution(int[] answers) {
            int[] answer = {};
            int length = answers.length;
            int[] first = new int[length];
            int[] second = new int[length];
            int[] third = new int[length];
            int[] firnum = {1,2,3,4,5};
            int[] secnum = {2,1,2,3,2,4,2,5};
            int[] thrnum = {3,3,1,1,2,2,4,4,5,5};
            int a = 0;
            int b = 0;
            int c = 0;

            for(int i = 0; i<length; i++){
                first[i] = firnum[i%5];
                second[i] = secnum[i%8];
                third[i] = thrnum[i%10];
            }
            for(int i = 0; i<length; i++){
                if(first[i]==answers[i])
                    a++;
                if(second[i]==answers[i])
                    b++;
                if(third[i]==answers[i])
                    c++;
            }
            int max = Math.max(Math.max(a,b),c);
            List<Integer> list = new ArrayList<>();
            if(max == a)
                list.add(1);
            if(max==b)
                list.add(2);
            if(max==c)
                list.add(3);
            answer = new int[list.size()];
            for(int i =0; i<list.size();i++)
                answer[i]=list.get(i);

            Arrays.sort(answer);
            return answer;
        }
    public static void main(String[] args) {
        Practice_Test solutionInstance = new Practice_Test();
        int[] answers = {1,3,2,4,2};
        int[] result = solutionInstance.solution(answers);
        System.out.println("the person with the highest number of correct answers: " + Arrays.toString(result));
    }

}
