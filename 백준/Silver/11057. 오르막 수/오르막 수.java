import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][9-i] = i+1;
        }
        for (int i = 1; i < N+1; i++) {
            dp[i][9] = 1;
        }
        for (int i = 2; i < N+1; i++) {
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = (dp[i-1][j] + dp[i][j+1])%10007;
            }
        }
        System.out.println(dp[N][0]%10007);
    }
}
