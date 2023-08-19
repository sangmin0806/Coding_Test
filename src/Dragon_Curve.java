import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Dragon_Curve {
    static int[] dr = {0,-1,0,1};
    static int[] dc = {1,0,-1,0};
    static boolean[][]map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count =0;

        map = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            map[row][col] = true;
            curveDir(col,row,dir,g);
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j]&&map[i][j+1]&&map[i+1][j+1] &&map[i+1][j])
                    count++;
            }
        }
        System.out.println(count);



    }
    public static void curveDir(int col, int row, int dir, int g){
        List<Integer> list = new ArrayList<>();
        list.add(dir);
        for (int i = 1; i < g+1; i++) {
            for (int j = list.size()-1; j >=0 ; j--) {
                list.add((list.get(j)+1)%4);
            }
        }
        for(int i: list){
            col +=dc[i];
            row +=dr[i];
            map[row][col]=true;
        }
    }
}
