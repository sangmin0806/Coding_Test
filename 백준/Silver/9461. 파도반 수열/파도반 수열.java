import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[101];
            dp[1] = dp[2] = dp[3] = 1;
            for (int j = 3; j <= N; j++) {
                dp[j] = dp[j-3] + dp[j-2];
            }
            System.out.println(dp[N]);
        }
    }
}
