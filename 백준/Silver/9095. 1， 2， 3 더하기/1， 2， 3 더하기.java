import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[N+1];

            System.out.println(recur(N));

        }
    }
    public static int recur(int n){
        if(n==1){
            dp[1] = 1;
        }
        else if(n==2){
            dp[2] = 2;
        }
        else if(n==3){
            dp[3] = 4;
        }
        else if(dp[n]==0){
            dp[n] = recur(n-1)+recur(n-2)+recur(n-3);
        }
        return dp[n];
    }
}
