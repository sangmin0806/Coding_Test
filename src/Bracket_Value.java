import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bracket_Value {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int cnt = 1;
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='('){
                stack.add(c);
                cnt *= 2;

            }
            else if(c=='['){
                stack.add(c);
                cnt *= 3;
            }
            else{
                if(c==')'){
                    if(stack.isEmpty()||stack.peek() == '['){
                        flag = false;
                        break;
                    }
                    if(str.charAt(i-1)=='('){
                        answer += cnt;

                    }
                    stack.pop();
                    cnt/=2;
                }else if(c==']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        flag=false;
                        break;
                    }
                    if(str.charAt(i-1)=='[') {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 3;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if(!flag || !stack.isEmpty()) {
            System.out.println(0);
        }else {
            System.out.println(answer);
        }
    }
}
