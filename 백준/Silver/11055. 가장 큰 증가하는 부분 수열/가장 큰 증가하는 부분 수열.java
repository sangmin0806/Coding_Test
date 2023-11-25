import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];
        int[] dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = A[1];
        int answer = dp[1];
        for (int i = 2; i <N+1; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if(A[j]<A[i]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max+A[i];
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);
    }
}
