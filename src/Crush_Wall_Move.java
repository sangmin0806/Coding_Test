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
    static int answer = Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken())+1;
        map = new int[N][M];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            String str = br.readLine();
            for (int j = 1; j < M; j++) {
                char c = str.charAt(j-1);
                if(c=='0'){
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = 1;
                    list.add(new int[]{i,j});
                }
            }
        }
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int[] wall = list.get(i);
            map[wall[0]][wall[1]] = 0;
            bfs(1,1);
            map[wall[0]][wall[1]] = 1;
            min = Math.min(answer,min);
        }

        if(N==2&&M==2) {
            System.out.println(1);
            return;
        }
        if(!flag)
            System.out.println(-1);
        else
            System.out.println(min);
    }
    public static void bfs(int row, int col){
        Queue<int[]> que = new LinkedList<>();
        int[][] copymap = map.clone();
        copymap[1][1] = 1;
        boolean[][] visited = new boolean[N][M];
        que.add(new int[]{row,col});
        while (!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            for (int i = 0; i < 4; i++) {
                int nrow = crow+dr[i];
                int ncol = ccol+dc[i];
                if(ncol<1||nrow<1||nrow>=N||ncol>=M)
                    continue;
                if(!visited[nrow][ncol]&&map[nrow][ncol]!=1){
                    visited[nrow][ncol] = true;
                    copymap[nrow][ncol] = copymap[crow][ccol]+1;
                    que.add(new int[]{nrow,ncol});
                    if(nrow==N-1&&ncol==M-1){
                        flag = true;
                        answer = copymap[nrow][ncol];
                        return;
                    }
                }
            }
        }

    }
}
