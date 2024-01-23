import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = index; j <= num; j++) {
                stack.push(j);
                sb.append("+").append("\n");
                index++;
            }
            if(num!=stack.pop()){
                System.out.println("NO");
                return;
            }
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
