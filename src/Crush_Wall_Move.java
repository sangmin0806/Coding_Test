import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Crush_Wall_Move {
    static int N,M;
    static int[][] map;
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,1,-1,0};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken())+1;
        map = new int[N][M];

        for (int i = 1; i < N; i++) {
            String str = br.readLine();
            for (int j = 1; j < M; j++) {
                char c = str.charAt(j-1);
                if(c=='0'){
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = 1;

                }
            }
        }
        bfs(1,1);

        if(!flag)
            System.out.println(-1);

    }
    public static void bfs(int row, int col){
        Queue<int[]> que = new LinkedList<>();
        int crash = 0;
        boolean[][][] visited = new boolean[N][M][2];
        que.add(new int[]{row,col,1,crash});
        while (!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            if(crow==N-1&&ccol==M-1){
                System.out.println(current[2]);
                flag = true;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nrow = crow+dr[i];
                int ncol = ccol+dc[i];
                if(ncol<1||nrow<1||nrow>=N||ncol>=M)
                    continue;
                int next_cnt = current[2]+1;

                if(map[nrow][ncol]==0){
                    if(current[3]==0 && !visited[nrow][ncol][0]){
                        que.add(new int[]{ nrow,ncol,next_cnt,current[3]});
                        visited[nrow][ncol][0] = true;
                    }
                    else if(current[3]==1 && !visited[nrow][ncol][1]){
                        que.add(new int[]{nrow,ncol,next_cnt,current[3]});
                        visited[nrow][ncol][1] =true;
                    }
                }
                else {
                    if(current[3]==0){
                        visited[nrow][ncol][1] = true;
                        que.add(new int[] { nrow,ncol,next_cnt,current[3]+1});
                    }

                }

            }

        }

    }
}
