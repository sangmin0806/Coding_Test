import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Population_Movement {
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            boolean[][] visited = new boolean[N][N];
            boolean check =false;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(!visited[i][j]) {
                        //System.out.println(i+" "+j);
                        int change = bfs(visited,i,j);
                        if(change>=2){
                            check = true;
                        }
                    }
                }
            }
            if(!check)
                break;
            day++;
        }
        System.out.println(day);
    }
    public static int bfs(boolean[][] visited, int row, int col){
        visited[row][col] = true;
        int change = 1;
        int sum = map[row][col];
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        que.add(new int[]{row,col});
        q2.add(new int[]{row,col});
        while(!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            //System.out.println(crow+" "+ccol);
            for(int i=0; i<4; i++){
                int nrow = crow+dx[i];
                int ncol = ccol+dy[i];
                if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                    continue;

                if( visited[nrow][ncol]==false&&Math.abs(map[crow][ccol]-map[nrow][ncol])>=L&&Math.abs(map[crow][ccol]-map[nrow][ncol])<=R){
                    visited[nrow][ncol] = true;
                    que.add(new int[]{nrow,ncol});
                    q2.add(new int[]{nrow,ncol});
                    sum+= map[nrow][ncol];
                    change++;

                }
            }
        }

        if(change==1){
            return 0;
        }
        else {
            while(!q2.isEmpty()) {
                int[] move = q2.poll();
                map[move[0]][move[1]] = sum/change;
            }
        }
        return change;
    }

}
