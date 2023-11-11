import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        long[] dp = new long[N+2];
        for (int i = N; i >= 1; i--) {
            int next = T[i]+i;
            if(next<=N+1){
                dp[i] = Math.max(dp[i+1],dp[next]+P[i]);
            }
            else {
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);
    }
}
