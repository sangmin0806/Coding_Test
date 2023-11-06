import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            dp = new int[N+1];
            fibonacci(N);
            if(N == 0){
                System.out.println(1+" "+0);
            }
            else {
                System.out.println(dp[N-1]+" "+dp[N]);
            }

        }
    }
    public static int fibonacci(int n){
        if(n ==0){
            dp[0] = 0;
        }
        else if(n==1){
            dp[1] = 1;
        }
        else if(dp[n]==0){
            dp[n] = fibonacci(n-1)+fibonacci(n-2);
        }
        return dp[n];
    }
}
