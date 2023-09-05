import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Red_Green_Color_Blindness {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] visited2;
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,1,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j]= str.charAt(j);
            }
        }
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    visited[i][j]=true;
                    dfs(i,j,map[i][j]);
                    count++;
                }
                if(!visited2[i][j]){
                    visited2[i][j] = true;
                    dfs2(i,j,map[i][j]);
                    count2++;
                }
            }
        }
        System.out.println(count+" "+count2);

    }
    public static void dfs(int row, int col, char color){
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                continue;
            if(!visited[nrow][ncol]&&color==map[nrow][ncol]){
                visited[nrow][ncol] = true;
                dfs(nrow,ncol,color);
            }
        }
    }
    public static void dfs2(int row, int col, char color){
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                continue;
            if(visited2[nrow][ncol])
                continue;
            if((color=='R'||color=='G')&&map[nrow][ncol]!='B'){
                visited2[nrow][ncol] = true;
                dfs2(nrow,ncol,map[nrow][ncol]);
            }
            else if(color=='B'&&map[nrow][ncol]=='B'){
                visited2[nrow][ncol] = true;
                dfs2(nrow,ncol,map[nrow][ncol]);
            }
        }
    }
}
