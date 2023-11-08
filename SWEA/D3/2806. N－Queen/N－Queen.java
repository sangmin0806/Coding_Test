
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int N;
    static int[][] map;
    static int answer = 0;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            answer = 0;
            map = new int[N][N];
            dfs(0,0);
            System.out.println("#"+test_case+" "+answer);
        }
    }
    public static void dfs(int row,int count){

        if(count==N){
            answer++;
            return;
        }
        for (int i = row; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(check(i,j)){
                    map[i][j] = 1;
                    dfs(i+1,count+1);
                    map[i][j] = 0;
                }
            }
        }

    }
    public static boolean check(int row, int col){
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if(map[row][i]!=0)flag = true;
        }
        for (int i = 0; i < N; i++) {
            if(map[i][col]!=0) flag = true;
        }
        for (int i = 0; i < N; i++) {
            if(row+i<N&&col+i<N){
                if(map[row+i][col+i]!=0) flag = true;
            }
            if(row-i>=0&&col+i<N){
                if(map[row-i][col+i]!=0) flag = true;
            }
            if(row+i<N&&col-i>=0){
                if(map[row+i][col-i]!=0) flag = true;
            }
            if(row-i>=0&&col-i>=0){
                if(map[row-i][col-i]!=0) flag = true;
            }
        }
        if(!flag){
            return true;
        }
        return false;
    }
}