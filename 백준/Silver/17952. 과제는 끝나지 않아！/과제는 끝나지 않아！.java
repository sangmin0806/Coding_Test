import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num==1){
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                stack.add(new int[]{A,--T});
                if(T==0){
                    sum+=A;
                    stack.pop();
                }
            }else if(!stack.isEmpty()){
                int[] head = stack.pop();
                if (--head[1] == 0) {
                    sum += head[0];
                } else stack.add(head);
            }
        }
        System.out.println(sum);

    }
}
