import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Supervision {
    static int N;
    static int M;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int[][] map;
    static ArrayList<int[]> list;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0&&map[i][j]!=6){
                    list.add(new int[]{i,j,map[i][j]});
                }
            }
        }
        for(int i = 0; i< list.size(); i++){
            dfs(list.get(i)[0],list.get(i)[1],list.get(i)[2],0);
        }


    }
    public static void dfs(int row, int col,int cctvNum,int dir){

        if(cctvNum == 1){
            for(int k = 0; k<4; k++) {
                int nrow = row + dx[k];
                int ncol = col + dy[k];
                if (nrow < 0 || ncol < 0 || nrow >= N || ncol >= M)
                    return;
                if (map[nrow][ncol] == 6)
                    return;
                if (!visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    map[nrow][ncol] = 7;
                    dfs(nrow, ncol, cctvNum,dir);
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            System.out.print(map[i][j]);
                        }
                        System.out.println();
                    }
                    visited[nrow][ncol] = false;
                    map[nrow][ncol] = 0;
                }
            }

        }
        else if (cctvNum ==2){

        }
        else if (cctvNum ==3){

        }
        else if (cctvNum ==4){

        }
        else if (cctvNum ==5){

        }
    }
}
