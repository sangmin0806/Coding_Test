import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class RGB_Distance {
    static int N;
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(Math.min(dfs(N-1,0),dfs(N-1,1)),dfs(N-1,2)));
    }
    public static int dfs(int N,int color){
        if(dp[N][color]==0){
            if(color==0){
                dp[N][0] = Math.min(dfs(N-1,1),dfs(N-1,2))+cost[N][0];
            }
            else if(color==1){
                dp[N][1] = Math.min(dfs(N-1,0),dfs(N-1,2))+cost[N][1];
            }
            else if(color==2){
                dp[N][2] = Math.min(dfs(N-1,1),dfs(N-1,0))+cost[N][2];
            }
        }
        return dp[N][color];
    }
}
