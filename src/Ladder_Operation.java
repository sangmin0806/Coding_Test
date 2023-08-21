import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder_Operation {
    static int N;
    static int M;
    static int H;
    static int[][] map;
    static boolean finish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 1;
            map[row][col+1] = 2;
        }
        for (int i = 0; i < 4; i++) {
            dfs(0,0,0,i);
        }
        System.out.println(-1);
    }
    public static void dfs(int row, int col, int count, int size){
        if(count == size){
            if(check()){
//                for (int i = 1; i < H+1; i++) {
//                    for (int j = 1; j < N+1; j++) {
//                        System.out.print(map[i][j]+" ");
//                    }
//                    System.out.println();
//                }
                System.out.println(count);

                System.exit(0);
            }
            return;
        }
        for (int i = row; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if(map[i][j]==0&&map[i][j+1]==0){
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(i,j,count+1,size);
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
    }
    public static boolean check(){

        for (int i = 1; i <= N; i++) {
            int row = 1;
            int col = i;
            while(true){
                if(row==H+1){
                    if(col == i){
                        break;
                    }
                    else {
                        return false;
                    }
                }
                if(map[row][col]==1){
                    col++;
                }
                else if(map[row][col]==2){
                    col--;
                }
                row++;
            }
        }
        return true;
    }
}
