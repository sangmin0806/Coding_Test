import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.*;

public class Baby_Shark {
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int N;
    static int[][] map;
    static int[][] count;
    static int[] shark;
    static int sharksize = 2;

    static List<int[]> fishlist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        fishlist = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {// 상어 위치
                    shark = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }
        bfs(shark[0], shark[1]);



    }
    public static void bfs(int row, int col){
        int feed = 0;
        count = new int[N][N];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row, col});
        while(true){
            int smallfish = 0;
            if(feed==sharksize){
                sharksize++;
                feed =0;
            }
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(map[i][j] != 0&&map[i][j]<sharksize) {
                        smallfish++;
                        break;
                    }
                }
            }
            if(smallfish<1) {
                return;
            }
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            for(int i = 0; i<4; i++){
                int nrow = crow+dx[i];
                int ncol = ccol+dy[i];
                if(nrow<0||ncol<0||nrow>=N||ncol>=N||map[nrow][ncol]>sharksize)
                    continue;
                count[nrow][ncol] = count[crow][ccol]+1;
                if(map[nrow][ncol]<sharksize&&map[nrow][ncol]!=0){
                    feed++;
                    map[nrow][ncol] = 0;
                    System.out.println("상어크기"+sharksize);
                    System.out.println(nrow+" "+ncol);
                    System.out.println(count[nrow][ncol]);
                    System.out.println();
                    que.clear();
                    que.add(new int[]{nrow,ncol});
                    break;
                }
                else{
                    que.add(new int[]{nrow,ncol});
                }
            }
        }

    }
}
