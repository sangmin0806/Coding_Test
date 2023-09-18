import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Guard {
    static int N,M,num;

    static int[] dr = {0,1,-1,0};
    static int[] dc = {1,0,0,-1};
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        int dir = 0;
        int point =0;
        for (int i = 0; i <num ; i++) {
            st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken());
            point = Integer.parseInt(st.nextToken());
            list.add(new int[]{dir,point});
        }
        int[] guard = new int[2];
        st = new StringTokenizer(br.readLine());
        guard[0] = Integer.parseInt(st.nextToken());
        guard[1] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            int[][] map = new int[M+1][N+1];
            boolean[][] visited = new boolean[M+1][N+1];
            bfs(map,guard[0],guard[1],list.get(i),visited);
        }
        System.out.println(sum);

    }
    public static void bfs(int[][] map,int dir, int point,int[] market,boolean[][] visited){
        int row = 0;
        int col = 0;
        if(dir==1){
            row = M;
            col = point;
        }else if(dir==2){
            row = 0;
            col = point;
        }else if(dir==3){
            row = M-point;
            col = 0;
        }else if(dir==4){
            row = M-point;
            col = N;
        }
        int mrow = 0;
        int mcol = 0;
        if(market[0]==1){
            mrow = M;
            mcol = market[1];
        }else if(market[0]==2){
            mrow = 0;
            mcol = market[1];
        }else if(market[0]==3){
            mrow = M-market[1];
            mcol = 0;
        }else if(market[0]==4){
            mrow = M-market[1];
            mcol = N;
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col});
        while (!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            for (int i = 0; i < 4; i++) {
                int nrow = crow + dr[i];
                int ncol = ccol + dc[i];
                if(nrow<0||ncol<0||nrow>=M+1||ncol>=N+1)
                    continue;
                if(nrow==0||ncol==0||nrow==M||ncol==N){
                    if(!visited[nrow][ncol]){
                        visited[nrow][ncol] = true;
                        map[nrow][ncol] = map[crow][ccol]+1;
                        if(nrow==mrow&&ncol==mcol){
                            sum += map[nrow][ncol];
                            return;
                        }
                        que.add(new int[]{nrow,ncol});
                    }
                }
            }
        }

    }
}
