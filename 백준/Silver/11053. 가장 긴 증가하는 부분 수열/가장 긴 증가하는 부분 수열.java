import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        dp = new int[N+1];
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            recur(i);
        }
        for (int i = 1; i <= N; i++) {
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
//        for (int i = 0; i <= N; i++) {
//            System.out.print(dp[i]+" ");
//        }
    }
    public static int recur(int n){
        if(dp[n]==0){
            dp[n] = 1;
            for (int i = n-1; i >= 1; i--) {
                if(arr[n]>arr[i]){

                    dp[n] = Math.max(recur(i)+1,dp[n]);

                }
            }
        }
        return dp[n];
    }
}
