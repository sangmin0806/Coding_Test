import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper {
    static int[][] map;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        map = new int[100][100];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int  col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            attach(row,col);
        }
        System.out.println(count);
    }
    public static void attach(int row,int col){
        for (int i = row; i < row+10; i++) {
            for (int j = col; j < col+10; j++) {
                if(map[i][j]!=1){
                    map[i][j] = 1;
                    count++;
                }
            }
        }
    }
}
