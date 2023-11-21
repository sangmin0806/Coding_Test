import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long answer = 1;
            if(N>M/2){
                N = M-N;
            }
            for (int i = 0; i < N; i++) {
                answer = answer*(M-i);
            }
            for (int i = 1; i <= N; i++) {
                answer = answer/i;
            }
            System.out.println(answer);
        }
    }
}
