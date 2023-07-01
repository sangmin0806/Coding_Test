import java.util.*;
public class Correct_Blank {
        boolean solution(String s) {
            boolean answer = false;
            Queue<String> queue = new LinkedList<>();
            int count = 0;
            int right = 0;
            int length = s.length();
            if((!(String.valueOf(s.charAt(0)).equals("(")))&&(!(String.valueOf(s.charAt(length-1)).equals(")"))))
                return answer=false;

            for(int i = 0; i<length;i++){
                String k = String.valueOf(s.charAt(i));
                if(k.equals("("))
                    count++;
                else if(k.equals(")"))
                    count--;
                if(count<0)
                    return answer=false;
            }

            if(count==0)
                answer = true;

            return answer;
        }
    public static void main(String[] args) {
        Correct_Blank solutionInstance = new Correct_Blank();
        String answers = "((()))";
        boolean result = solutionInstance.solution(answers);
        System.out.println(result);
    }
}

