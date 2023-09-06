import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Safe_Area {
    static int N;
    static int[][] map;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int height = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height,map[i][j]);
            }
        }
        for (int i = 0; i < height; i++) {
            boolean[][] visited = new boolean[N][N];
            flood(i,visited);
        }
        System.out.println(answer);
    }
    public static void flood(int height, boolean[][] visited){
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]<height){
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    visited[i][j] = true;
                    dfs(i,j,visited);
                    count++;
                }
            }
        }
        answer = Math.max(answer,count);
    }
    public static void dfs(int row, int col,boolean[][]visited){
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                continue;
            if(!visited[nrow][ncol]){
                visited[nrow][ncol] = true;
                dfs(nrow,ncol,visited);
            }
        }
    }
}
