import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[] dp = new long[N+1];
        dp[1] = arr[1];
        for (int i = 2; i < N+1; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i],arr[i]);
        }


        long max = Integer.MIN_VALUE;
        for (int i = 1; i < N+1; i++) {
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
