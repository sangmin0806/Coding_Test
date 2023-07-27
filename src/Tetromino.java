import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tetromino {
    static int[][] map;
    static boolean[][] visited;
    static int N;

    static int max = 0;
    static int M;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                visited[i][j] = true;
                dfs(i,j,1,map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);

    }
    public static void dfs(int row, int col, int count, int sum){

        if(count ==4) {
            max = Math.max(max,sum);
            return;
        }

        for(int i = 0; i<4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (nrow < 0 || ncol < 0 || nrow >= N || ncol >= M)
                continue;
            if (!visited[nrow][ncol]){
                if(count==2){
                    visited[nrow][ncol] = true;
                    dfs(row,col,count+1,sum+map[nrow][ncol]);
                    visited[nrow][ncol] = false;
                }
                visited[nrow][ncol] = true;
                dfs(nrow,ncol,count+1,sum+map[nrow][ncol]);
                visited[nrow][ncol] = false;
            }
        }
    }

}
