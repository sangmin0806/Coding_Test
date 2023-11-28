import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[K+1][N+1];
        for (int i = 1; i < K+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(arr[j][0]<=i){
                    dp[i][j] = Math.max(dp[i-arr[j][0]][j-1]+arr[j][1],Math.max(dp[i][j-1],arr[j][1]));
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        System.out.println(dp[K][N]);
//        for (int i = 1; i < N+1; i++) {
//            for (int j = 1; j < K+1; j++) {
//                System.out.print(dp[j][i]+" ");
//            }
//            System.out.println();
//        }
    }
}
