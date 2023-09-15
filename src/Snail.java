import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Snail {
    static int N;
    static int answer;
    static int[][] map;
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        int num = N / 2 + 1;
        dfs(num,num,1,3);
        int row=0;
        int col = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                sb.append(map[i][j]).append(" ");
                if(map[i][j]==answer){
                    row =i;
                    col = j;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(row+" "+col);
    }
    public static void dfs(int row, int col,int count,int dir){
        map[row][col] = count;
        int ndir = (dir+1)%4;
        if(map[row+dr[ndir]][col+dc[ndir]]==0) {
            dir = ndir;
        }
        row += dr[dir];
        col += dc[dir];
        if(row<1||col<1||row>=N+1||col>=N+1)
            return;
        dfs(row,col,count+1,dir);
    }


}
