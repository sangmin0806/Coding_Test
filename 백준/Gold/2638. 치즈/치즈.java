import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean flag = false;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while (true){
            bfs(0,0);
            if(!flag) break;
            count++;

        }

        System.out.println(count);

    }
    public static void bfs(int row, int col){
        flag = false;
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {row,col});
        boolean[][] visited = new boolean[N][M];
        visited[row][col] = true;
        while (!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            for (int i = 0; i < 4; i++) {
                int nrow = crow + dr[i];
                int ncol = ccol + dc[i];
                if(nrow<0||ncol<0||nrow>=N||ncol>=M)
                    continue;
                if(visited[nrow][ncol])
                    continue;
                visited[nrow][ncol] = true;
                if(copy[nrow][ncol]!=0){
                    flag = true;
                    visited[nrow][ncol] = false;
                    copy[nrow][ncol] += 1;
                    if(copy[nrow][ncol]>=3){
                        map[nrow][ncol] = 0;
                    }
                }
                else{
                    que.add(new int[]{nrow,ncol});
                }
            }
        }
    }
}
