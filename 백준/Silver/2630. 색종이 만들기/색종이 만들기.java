
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int b = 0;
    static int w = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(0, 0, N);
        System.out.println(w);
        System.out.println(b);
    }
    public static void cut(int row, int col,int size) {
        int blue;
        if(map[row][col]==1) {
            blue = 1;
        }
        else {
            blue = 0;
        }
        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if(blue!=map[i][j]) {
                    cut(row, col, size/2);
                    cut(row+size/2, col, size/2);
                    cut(row, col+size/2, size/2);
                    cut(row+size/2, col+size/2, size/2);
                    return;
                }

            }
        }
        if(blue==1) b++;
        else w++;
    }
}