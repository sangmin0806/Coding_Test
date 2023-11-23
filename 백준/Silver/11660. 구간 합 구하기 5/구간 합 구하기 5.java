import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1];
        int[][] arr = new int[M][4];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[N+1][N+1];
        int sum = 0;
        for (int i = 1; i < N+1; i++) {
            sum += map[1][i];
            dp[1][i] = sum;
        }
        sum = 0;
        for (int i = 1; i < N+1; i++) {
            sum += map[i][1];
            dp[i][1] = sum;
        }
        for (int i = 2; i < N+1; i++) {
            for (int j = 2; j < N+1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]+map[i][j]-dp[i-1][j-1];
            }
        }
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int row = arr[i][2];
            int col = arr[i][3];
            answer = dp[row][col];
            row = arr[i][0]-1;
            col = arr[i][3];
            answer -= dp[row][col];
            row = arr[i][2];
            col = arr[i][1]-1;
            answer -= dp[row][col];
            row = arr[i][0]-1;
            col = arr[i][1]-1;
            answer += dp[row][col];
            if(i==M-1){
                sb.append(answer);
            }else{
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);

    }
}
