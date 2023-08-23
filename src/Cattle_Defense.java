import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cattle_Defense {
    static int N,M,D;
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int enemy = 0;
    static int[] archerList = new int[3];
    static int[] dr = {0,-1,0,1};
    static int[] dc = {-1,0,1,0};
    static int[][] copymap;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N+1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(max);
    }
    public static void dfs(int col,int cnt){
        if(cnt==3){
            enemy = 0;
            kill();
            max = Math.max(max,enemy);
            return;
        }
        for (int i = col; i < M; i++) {
            archerList[cnt] = i;
            dfs(i+1, cnt + 1);
        }
    }
    public static void kill(){
        int count = 1;
        copymap = new int[N+1][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copymap[i][j]=map[i][j];
            }
        }
        while(true) {
            if(count==N*M){
                break;
            }
            count = 0;
            for (int k = 0; k < 3; k++) {
                Queue<int[]> que = new LinkedList<>();
                //궁수 한명이 잡을 수 있는 적(enemylist에서 체크)
                que.add(new int[]{N, archerList[k]});
                visited = new boolean[N][M];
                outloop:
                while (!que.isEmpty()) {
                    int[] current = que.poll();
                    int crow = current[0];
                    int ccol = current[1];
                    for (int i = 0; i < 4; i++) {
                        int nrow = crow + dr[i];
                        int ncol = ccol + dc[i];
                        if (nrow < 0 || ncol < 0 || nrow >= N || ncol >= M)
                            continue;
                        if (Math.abs(N - nrow) + Math.abs(archerList[k] - ncol) > D)
                            continue;
                        if (!visited[nrow][ncol]) {
                            visited[nrow][ncol] = true;
                            que.add(new int[]{nrow, ncol});
                            if (copymap[nrow][ncol] == 1) {//처음쏘는 적이면 처치수 +1
                                enemy++;
                                copymap[nrow][ncol] = -1;
                                break outloop;
                            } else if (copymap[nrow][ncol] == -1) {//두번째 쏘는 적이면 처치수 계산 x
                                break outloop;
                            }
                        }
                    }
                }
            }
            for (int i = N-1; i >=0; i--) {// 적 전진
                for (int j = 0; j < M; j++) {
                    if(copymap[i][j]==-1){
                        copymap[i][j]=0;
                    }
                    else if(copymap[i][j]==1){
                        copymap[i+1][j]=copymap[i][j];
                        copymap[i][j]=0;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(copymap[i][j]==0)
                        count++;
                }
            }
        }

    }
}
