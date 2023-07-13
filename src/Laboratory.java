import java.util.Scanner;
import java.util.Stack;

public class Laboratory {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int map[][] = new int[N][M];
        int count =0;
        int row = 0;
        int col = 0;
        for(int i = 0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }

    }
    public static void dfs(int row,int col, int[][] map){

    }

}
