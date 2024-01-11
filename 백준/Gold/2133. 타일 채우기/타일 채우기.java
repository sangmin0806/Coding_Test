import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[31];
        dp[2] = 3;
        dp[4] = 11;
        for (int i = 6; i < 31; i++) {
            if(i%2==1) continue;
            dp[i] = dp[i-2]*3;
            for (int j = 2; j < i-2; j++) {
                dp[i] += dp[j]*2;
            }
            dp[i] += 2;
        }
        System.out.println(dp[N]);
    }
}
