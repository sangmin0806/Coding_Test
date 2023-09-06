import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Calculate_Area {
    static int N,M,K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static List<Integer> list;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int lc = Integer.parseInt(st.nextToken());
            int lr = Integer.parseInt(st.nextToken());
            int rc = Integer.parseInt(st.nextToken());
            int rr = Integer.parseInt(st.nextToken());
            draw(lc,lr,rc,rr);
        }
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]&&map[i][j]==0){
                    visited[i][j] = true;
                    dfs(i,j);
                    list.add(size);
                    size= 0;
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");

        }
    }
    public static void draw(int lc,int lr,int rc, int rr){
        for (int i = lr; i < rr; i++) {
            for (int j = lc; j < rc; j++) {
                map[i][j] = 1;
            }
        }
    }
    public static void dfs(int row, int col){
        size++;
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow<0||ncol<0||nrow>=N||ncol>=M)
                continue;
            if (!visited[nrow][ncol]&&map[nrow][ncol]==0){
                visited[nrow][ncol] = true;
                dfs(nrow,ncol);
            }
        }
    }
}
