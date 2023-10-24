import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        dfs(0,0);

    }
    public static void dfs(int row, int col){
        if(row==9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(col==9){
            dfs(row+1,0);
            return;
        }
        if(map[row][col]!=0){
            dfs(row,col+1);
        }
        else if(map[row][col]==0){
            for (int i = 1; i <= 9; i++) {
                boolean rowflag = false;
                for (int j = 0; j < 9; j++) {
                    if(map[row][j] == i){
                        rowflag = true;
                        break;
                    }
                }
                boolean colflag = false;
                for (int j = 0; j < 9; j++) {
                    if(map[j][col] == i){
                        colflag = true;
                        break;
                    }
                }
                boolean squareflag = false;
                squareflag = squareCheck(row,col,i);
                if(!rowflag&&!colflag&&!squareflag){
                    map[row][col] = i;
                    dfs(row,col+1);
                }
            }
            map[row][col] = 0;

        }
    }
    public static boolean squareCheck(int row,int col,int num){
        if(row<3){
            row = 0;
        }
        else if(row<6){
            row = 3;
        } else if (row <9) {
            row = 6;
        }
        if(col<3){
            col = 0;
        }
        else if(col<6){
            col = 3;
        }
        else if(col<9){
            col = 6;
        }
        for (int i = row; i <row+3; i++) {
            for (int j = col; j < col+3; j++) {
                if(map[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }
}
