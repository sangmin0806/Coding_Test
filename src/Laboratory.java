import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Laboratory {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int M;
    static int maxsafe = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        int temp =0;
        for(int i = 0; i<N; i++){
            for(int j=0; j<M; j++){
                temp = sc.nextInt();
                map[i][j] = temp;
            }
        }
        dfs(0);
        System.out.println(maxsafe);

    }
    public static void dfs(int wallcount){
        if(wallcount == 3){
            bfs();
            return;
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(wallcount +1);
                    map[i][j] = 0;
                }
            }
        }

    }
    public static void bfs(){
        int[][] copymap = new int[N][M];
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                copymap[i][j] = map[i][j];
                if(map[i][j]==2)
                    que.add(new int[]{i,j});
            }
        }
        while (!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            for(int i = 0; i<4;i++){
                int nrow = crow+dx[i];
                int ncol = ccol+dy[i];
                if(nrow<0||ncol<0||nrow>=N||ncol>=M)
                    continue;
                if(copymap[nrow][ncol]==0){
                    que.add(new int[]{nrow,ncol});
                    copymap[nrow][ncol]=2;
                }
            }
        }
        SafeZone(copymap);
    }
    public static void SafeZone(int[][] copymap){
        int safe = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(copymap[i][j]==0){
                    safe++;
                }
            }
        }
        if(maxsafe<safe)
            maxsafe=safe;
    }

}
