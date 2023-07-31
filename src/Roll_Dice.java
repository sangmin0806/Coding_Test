import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Roll_Dice {
    static int N;
    static int M;
    static int x;
    static int y;
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int[] dice = new int[7];
        map = new int[N][M];
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(map[x][y]==0){
            map[x][y] = dice[6];
        }
        else{
            dice[6] = map[x][y];
            map[x][y] = 0;
        }
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[K];
        for(int i = 0; i<K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            int nrow = x+dx[arr[i]-1];
            int ncol = y+dy[arr[i]-1];
            if(nrow<0||ncol<0||nrow>=N||ncol>=M)
                continue;
            x = nrow;
            y = ncol;
            int temp;
            if(arr[i]==1){
                temp = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = dice[1];
                dice[1] = temp;
            }
            else if(arr[i]==2){
                temp = dice[6];
                dice[6] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
            }
            else if(arr[i]==3){
                temp = dice[6];
                dice[6] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
            }
            else if(arr[i]==4){
                temp = dice[6];
                dice[6] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
            }
            if(map[nrow][ncol]==0){
                map[nrow][ncol] = dice[6];
            }
            else{
                dice[6] = map[nrow][ncol];
                map[nrow][ncol] = 0;
            }
            System.out.println(dice[1]);
        }
    }
}
