import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
class Solution
{
	 static int[][] map;
    static HashSet<String> set;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int count =0;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            count = 0;
            map = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            set = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(map[i][j]);
                    dfs(i,j,sb);
                }
            }
            System.out.println("#"+test_case+" "+set.size());
        }
    }
    public static void dfs(int row, int col,StringBuilder sb){

        if(sb.length()==7){
            set.add(sb.toString());
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nrow = row + dr[k];
            int ncol = col + dc[k];
            if(nrow<0||ncol<0||nrow>=4||ncol>=4) continue;
            sb.append(map[nrow][ncol]);
            dfs(nrow,ncol,sb);
            sb.delete(sb.length()-1,sb.length());
        }

    }
}