import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static boolean flag = false;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int test = sc.nextInt();
            map = new int[16][16];
            int row = 0;
            int col =0;
            flag = false;
            for (int i = 0; i < 16; i++) {
                String str = sc.next();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = str.charAt(j)-'0';
                    if(map[i][j]==2){
                        row = i;
                        col = j;
                    }
                }
            }
            visited = new boolean[16][16];

            dfs(row,col,test);
            if(!flag) System.out.println("#" + test+" " + 0);
        }
    }
    public static void dfs(int row,int col,int test){
        if(!flag&&map[row][col]==3){
            System.out.println("#" + test+" " + 1);
            flag = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(!visited[nrow][ncol]&&map[nrow][ncol]!=1){
                visited[nrow][ncol] = true;
                dfs(nrow,ncol,test);
                visited[nrow][ncol] = false;
            }
        }
    }
}