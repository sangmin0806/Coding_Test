import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Number_Rectangle {
    static int N;
    static int M;
    static int answer=0;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i,j);
                max = Math.max(max,answer);
            }
        }
        System.out.println(max);
    }
    public static void dfs(int row, int col){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; col+i < M; i++) {
            if(map[row][col+i]==map[row][col]){
                list.add(i);
            }
        }
        if(list.isEmpty()){
            return;
        }

        for (int i = list.size()-1; i >=0; i--) {
            if(N<=row+list.get(i))
                continue;
            if(map[row+list.get(i)][col]==map[row][col] && map[row+list.get(i)][col+list.get(i)]==map[row][col]){
                answer = (list.get(i)+1)*(list.get(i)+1);
                return;
            }
        }
    }
}
