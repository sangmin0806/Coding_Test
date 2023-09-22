import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Competitive_Spread {
    static int N,K;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] map;

    static List<int[]> list;
    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        answer = new int[3];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0){
                    list.add(new int[]{map[i][j],i,j,0});
                }
            }
        }
        Collections.sort(list,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });


        st = new StringTokenizer(br.readLine());
        answer[0] = Integer.parseInt(st.nextToken());
        answer[1] = Integer.parseInt(st.nextToken());
        answer[2] = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(map[answer[1]-1][answer[2]-1]);

    }
    public static void bfs(){
        Queue<int[]> que = new LinkedList<>();
        for (int[] ints : list) {
            que.add(ints);
        }
        while (!que.isEmpty()){
            int[] current = que.poll();
            int virusnum = current[0];
            int crow = current[1];
            int ccol = current[2];
            int time = current[3];
            if(time==answer[0]) return;
            for (int i = 0; i < 4; i++) {
                int nrow = crow + dr[i];
                int ncol = ccol + dc[i];
                if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                    continue;
                if(map[nrow][ncol]==0){
                    map[nrow][ncol] = virusnum;
                    que.add(new int[]{virusnum,nrow,ncol,time+1});
                }
            }
        }

    }
}
