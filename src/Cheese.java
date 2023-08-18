import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cheese {
    static int N;
    static int M;
    static int[][] map;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cheesecnt = 0;
    static int precheesecnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int count =0;
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                    cheesecnt++;
            }
        }
        while(true){
            if(cheesecnt==0)
                break;
            count++;
            precheesecnt = cheesecnt;
            bfs(0,0);
        }

        System.out.println(count);
        System.out.println(precheesecnt);

    }
    
    public static void bfs(int row, int col){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col});
        while (!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            for(int i =0; i<4; i++){
                int nrow = crow +dx[i];
                int ncol = ccol + dy[i];
                if(nrow<0||ncol<0||nrow>=N||ncol>=M)
                    continue;
                if(visited[nrow][ncol])
                    continue;
                visited[nrow][ncol] = true;
                if(map[nrow][ncol]==1){
                    map[nrow][ncol] = 2;
                    cheesecnt--;
                    continue;
                }
                que.add(new int[] {nrow,ncol});

            }
        }
    }
}
