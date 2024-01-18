import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            String str = br.readLine();
            StringBuilder answer = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)==' '){
                    sb.reverse();
                    sb.append(' ');
                    answer.append(sb);
                    sb = new StringBuilder();
                    continue;
                }
                sb.append(str.charAt(i));
            }
            sb.reverse();
            answer.append(sb);
            System.out.println(answer);
        }
    }
}
