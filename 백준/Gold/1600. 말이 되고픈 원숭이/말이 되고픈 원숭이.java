import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int K,W,H;
    static int[][] map;
    static boolean[][][] visited;
    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};
    static int hdr[] = {-1,-2,-2,-1,1,2,2,1};
    static int hdc[] = {-2,-1,1,2,2,1,-1,-2};
    static boolean flag = false;
    static int answer =0;
    static class Monkey{
        int row;
        int col;
        int Kcount;
        int totalcount;

        public Monkey(int row, int col, int kcount, int totalcount) {
            this.row = row;
            this.col = col;
            Kcount = kcount;
            this.totalcount = totalcount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        if(!flag){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }
    public static void bfs(){
        Queue<Monkey> que = new ArrayDeque<>();
        que.offer(new Monkey(0,0,K,0));
        visited[0][0][K] = true;
        while (!que.isEmpty()){
            Monkey current = que.poll();
            //System.out.println(current.row+" "+current.col+" "+ current.Kcount);
            if(current.row==H-1&&current.col==W-1){
                flag = true;
                answer = current.totalcount;
                return;
            }
            if(current.Kcount>0){
                for (int i = 0; i < 8; i++) {
                    int nrow = current.row+ hdr[i];
                    int ncol = current.col +hdc[i];
                    int ncount = current.Kcount-1;
                    if(nrow<0||ncol<0||nrow>=H||ncol>=W) continue;
                    if(visited[nrow][ncol][ncount]) continue;
                    if(map[nrow][ncol]==1) continue;
                    que.offer(new Monkey(nrow,ncol,ncount, current.totalcount+1));
                    visited[nrow][ncol][ncount] = true;
                }
            }
            for (int i = 0; i < 4; i++) {
                int nrow = current.row+ dr[i];
                int ncol = current.col +dc[i];
                if(nrow<0||ncol<0||nrow>=H||ncol>=W) continue;
                if(visited[nrow][ncol][current.Kcount]) continue;
                if(map[nrow][ncol]==1) continue;
                que.offer(new Monkey(nrow,ncol,current.Kcount, current.totalcount+1));
                visited[nrow][ncol][current.Kcount] = true;
            }
        }

    }
}
