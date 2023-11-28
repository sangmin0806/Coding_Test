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
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][K+1];//물건의 인덱스별, 가치별 dp. 같은 dp여도, 다른 인덱스 일수도 있어서
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                if(j-W[i]>=0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-W[i]]+V[i]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        System.out.println(dp[N][K]);
        
    }
}
