import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Robot_Cleaner {
    static int count=0;
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {-1,0,1,0};//북서남동 북동남서
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        if(d == 1)
            d = 3;
        else if(d ==3)
            d = 1;

        bfs(r,c,d);
        System.out.println(count);
    }
    public static void bfs(int row, int col,int direct){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col});
        while (!que.isEmpty()){
            boolean clean = false;
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            if(map[crow][ccol]==0){
                map[crow][ccol] = 3;
                count++;
                //System.out.println(crow+" " + ccol);
            }
            for(int i = direct+1; i<direct+5;i++){

                int nrow = crow + dx[i%4];
                int ncol = ccol + dy[i%4];
                if(map[nrow][ncol] == 0){
                    direct = i;
                    que.add(new int[]{nrow,ncol});
                    clean = true;
                    break;
                }
            }
            if(clean==false){
                int brow = crow+dx[(direct+2)%4];
                int bcol = ccol+dy[(direct+2)%4];
                if(map[brow][bcol]==1){
                    break;
                }
                else {
                    que.add(new int[]{brow, bcol});
                    //System.out.println("gkdl "+brow+" "+ bcol);
                }
            }
        }
    }
}
