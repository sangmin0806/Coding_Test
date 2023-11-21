import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][N];
        dp[0][0] = map[0][0];
        int max = map[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                int left = 0;
                if(j-1>=0){
                    left = dp[i-1][j-1]+map[i][j];
                }
                int right = 0;
                if(j+1<=i){
                    right = dp[i-1][j]+map[i][j];
                }
                dp[i][j] = Math.max(right,left);
                if(i==N-1){
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
