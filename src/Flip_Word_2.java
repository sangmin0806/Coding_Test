import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Flip_Word_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean bracket = false;
        Stack<String> stack = new Stack<>();
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i)=='<'){
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                bracket = true;
            }
            else if(str.charAt(i)=='>'){
                bracket = false;
                sb.append(">");
                continue;
            }
            if(!bracket){
                if(str.charAt(i)==' '){
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }
                else{
                    stack.add(String.valueOf(str.charAt(i)));
                }
                if(i == str.length()-1){
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
            }
            else{
                sb.append(str.charAt(i));
            }

        }
        System.out.print(sb);
    }
}
