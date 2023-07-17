import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tomato {
    static int[] dx = {0,1,0,-1,0,0};
    static int[] dy = {1,0,-1,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static int M;
    static int N;
    static int H;
    static int[][][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];

        for(int k = 0; k<H; k++){
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<M; j++){
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(bfs()-1);

        br.close();
    }
    public static int bfs(){
        int max= 0;
        int answer =0;
        Queue<int[]> que = new LinkedList<>();
        for(int k = 0; k<H; k++){
            for(int i = 0; i<N; i++){
                for(int j = 0; j<M; j++){
                    if(map[k][i][j]==1){
                        que.add(new int[]{k,i,j});

                    }
                }
            }
        }

        while (!que.isEmpty()){
            int[] current = que.poll();
            int cheight = current[0];
            int crow = current[1];
            int ccol = current[2];
            for(int i =0; i<6; i++){
                int nrow = crow+dx[i];
                int ncol = ccol+dy[i];
                int nheight = cheight+dz[i];
                if(nrow<0||ncol<0||nheight<0||nrow>=N||ncol>=M||nheight>=H)
                    continue;
                if(map[nheight][nrow][ncol]==0){
                    map[nheight][nrow][ncol] =map[cheight][crow][ccol]+ 1;
                    que.add(new int[]{nheight,nrow,ncol});
                }
            }

        }
        for(int k = 0; k<H; k++){
            for(int i = 0; i<N; i++){
                for(int j = 0; j<M; j++){
                    if(map[k][i][j]==0){
                        answer = 0;
                        return answer;
                    }
                    max = Math.max(max,map[k][i][j]);
                }
            }
        }
        answer = max;
        return answer;
    }
}
