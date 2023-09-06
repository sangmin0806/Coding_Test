import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Avoid_Garbage {
    static int N,M;
    static int[][]map;
    static int trash;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static boolean[][] visited;
    static int answer = 0;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        trash = Integer.parseInt(st.nextToken());
        for (int j = 0; j < trash; j++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 1;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                if(map[i][j]==1&&!visited[i][j]) {
                    visited[i][j] = true;
                    count = 0;
                    dfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int row, int col){
        count++;
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow<1||ncol<1||nrow>=N+1||ncol>=M+1)
                continue;
            if(!visited[nrow][ncol]&&map[nrow][ncol]==1){
                visited[nrow][ncol] = true;
                dfs(nrow,ncol);
            }
        }
        answer = Math.max(answer,count);
    }
}
