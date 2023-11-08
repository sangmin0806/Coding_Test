import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(recur(N));
    }
    public static int recur(int n){
        if(n==0){
            return 0;
        }
        else if(n==1){
            dp[1] = arr[1];
        }
        else if(n==2){
            dp[2] = arr[1]+arr[2];
        }
        else if(dp[n]==0){
            dp[n] = Math.max(recur(n-3)+arr[n-1],recur(n-2)) + arr[n];
        }
        return dp[n];
    }
}
