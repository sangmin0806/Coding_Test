import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[5001];
        dp[0] = Integer.MAX_VALUE;
        dp[1]= Integer.MAX_VALUE;
        dp[2] = Integer.MAX_VALUE;
        dp[3] = 1;
        dp[5] = 1;
        dp[4] = Integer.MAX_VALUE;
        dp[7] = Integer.MAX_VALUE;
        dp[6] = 2;
        for (int i = 8; i <= N; i++) {
            dp[i] = Math.min(dp[i-3],dp[i-5])+1;
        }
        if(N==4||N==7){
            System.out.println(-1);
        }
        else {
            System.out.println(dp[N]);
        }

    }
}
