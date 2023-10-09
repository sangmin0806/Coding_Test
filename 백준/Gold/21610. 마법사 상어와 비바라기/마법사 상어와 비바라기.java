import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {0,-1,-1,-1,0,1,1,1};
    static int[] dc = {-1,-1,0,1,1,1,0,-1};
    static int[] cr = {-1,1,1,-1};
    static int[] cc = {-1,-1,1,1};
    static int N,M;
    static int[][] map;
    static int[][] move;
    static Queue<int[]> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            move[i][0] = Integer.parseInt(st.nextToken());
            move[i][1] = Integer.parseInt(st.nextToken());
        }
        initCloud();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
    public static void initCloud(){
        que = new LinkedList<>();
        que.add(new int[]{N-1,0});
        que.add(new int[]{N-1,1});
        que.add(new int[]{N-2,0});
        que.add(new int[]{N-2,1});
        magic();
    }
    public static void magic(){
        for (int i = 0; i < M; i++) {
            List<int[]> list = new ArrayList<>(moveCloud(i));//구름 이동
            upWater(list);
            createCloud(list);
        }
    }
    public static List<int[]> moveCloud(int index){
        List<int[]> list = new ArrayList<>();
        int len = que.size();

        for (int i = 0; i < len; i++) {
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            int nrow = crow;
            int ncol = ccol;
            for (int j = 0; j < move[index][1]; j++) {
                nrow = (nrow + dr[move[index][0]-1])%N;
                ncol = (ncol + dc[move[index][0]-1])%N;
                if(nrow<0)
                    nrow = N-1;
                if(ncol<0)
                    ncol = N-1;
            }
            map[nrow][ncol] += 1;
            list.add(new int[]{nrow,ncol});
        }
        return list;
    }
    public static void upWater(List<int[]> list){
        for (int i = 0; i < list.size(); i++) {
            int[] current = list.get(i);
            int crow = current[0];
            int ccol = current[1];
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int nrow = crow + cr[j];
                int ncol = ccol + cc[j];
                if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                    continue;
                if(map[nrow][ncol]>0){
                    count++;
                }
            }
            map[crow][ccol] += count;
        }

    }
    public static void createCloud(List<int[]> list){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean flag = false;
                for (int k = 0; k < list.size(); k++) {
                    if(i==list.get(k)[0]&&j==list.get(k)[1]) {
                        flag = true;

                        break;
                    }
                }
                if(!flag&&map[i][j]>=2){
                    que.add(new int[]{i,j});
                    map[i][j] -= 2;
                }
            }
        }
    }
}
