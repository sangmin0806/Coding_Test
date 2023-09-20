import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baby_Shark {
    static int N;
    static int[][] map;
    static int[]shark;
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};
    static int time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        shark = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    shark[0] = i;
                    shark[1] = j;
                }
            }
        }
        eat(shark[0],shark[1],2,0);//먹을수 있는 물고기 있는지 확인
        System.out.println(time);
    }
    public static void eat(int row,int col,int sharkSize,int foodcnt){
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int [][] timecnt = new int[N][N];
        List<int[]> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        visited[row][col] = true;
        que.add(new int[]{row,col});

        while (!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            for (int i = 0; i < 4; i++) {
                int nrow = crow + dr[i];
                int ncol = ccol + dc[i];
                if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                    continue;
                if(!visited[nrow][ncol]&&map[nrow][ncol]<=sharkSize){
                    timecnt[nrow][ncol] = timecnt[crow][ccol]+1;
                    if(map[nrow][ncol]<sharkSize&&map[nrow][ncol]!=0&&min>=timecnt[nrow][ncol]) {
                        min = timecnt[nrow][ncol];
                        list.add(new int[] {nrow,ncol});
                    }
                    visited[nrow][ncol] = true;
                    que.add(new int[]{nrow,ncol});
                }
            }
        }
        if(list.isEmpty()) return;
        int minrow = Integer.MAX_VALUE;
        int mincol = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int[] food = list.get(i);
            if(food[0]<minrow){
                minrow = food[0];
                mincol = food[1];
            }else if(food[0]==minrow){
                if(food[1]<mincol){
                    mincol = food[1];
                }
            }
        }
        map[row][col] = 0;
        map[minrow][mincol] = 9;
        shark[0] = minrow;
        shark[1] = mincol;
        foodcnt++;
        if(foodcnt==sharkSize){
            sharkSize++;
            foodcnt = 0;
        }
        time += timecnt[minrow][mincol];
        //System.out.println(time +" "+ minrow +" "+ mincol+" "+sharkSize);
        eat(shark[0],shark[1],sharkSize,foodcnt);
    }
}
