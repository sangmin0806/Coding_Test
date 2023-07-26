import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Snake {
    static Queue<int[]> que = new LinkedList<>();
    static int N;
    static int[][] map;
    static int[] time;
    static String[] dir;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for(int i =1; i<N+1; i++){
            for(int j =1; j<N+1; j++){
                map[i][j] = 0;
            }
        }
        map[1][1] = 2;

        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 1;
        }
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        time = new int[L];
        dir= new String[L];
        for(int i = 0; i<L;i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            dir[i] = st.nextToken();
        }
        que.add(new int[]{1,1});
        move(1,1,1,1);
        System.out.println(count);

    }
    public static void move(int row, int col,int cdx,int cdy) {
        while (true) {
            count++;
            int nrow = row + dx[cdx];
            int ncol = col + dy[cdy];
            que.add(new int[]{nrow,ncol});

            if (nrow < 1 || ncol < 1 || nrow >= N + 1 || ncol >= N + 1 || map[nrow][ncol] == 2)
                return;
            if(map[nrow][ncol]==0){
                map[nrow][ncol]=2;
                int[] tail = que.poll();
                map[tail[0]][tail[1]]=0;
            }
            else
                map[nrow][ncol]=2;
            row = nrow;
            col = ncol;
            for (int i = 0; i < time.length; i++) {
                if (count == time[i]) {
                    if (dir[i].equals("D")) {
                        cdx = (cdx + 3) % 4;
                        cdy = (cdy + 3) % 4;
                    } else if (dir[i].equals("L")) {
                        cdx = (cdx + 1) % 4;
                        cdy = (cdy + 1) % 4;
                    }
                    break;
                }
            }
        }

    }
}
