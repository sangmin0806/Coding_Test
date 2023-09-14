import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Professor_Hyeonwoo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            int five = 5;
            while (N>=five){
                answer += N/five;
                five= five*5;
            }
            System.out.println(answer);
        }

    }
}
