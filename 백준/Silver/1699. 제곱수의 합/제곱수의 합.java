import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;
        for (int i = 2; i <N+1; i++) {
            int sqrt = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= sqrt; j++) {
                min = Math.min(dp[i-j*j]+1,min);
            }
            dp[i] = min;

        }
        System.out.println(dp[N]);
    }
}
