import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MineCraft {
    static int N;
    static int M;
    static int B;
    static int[][] map;
    static int count =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int result = Integer.MAX_VALUE;
        map = new int[N][M];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int height = 0;
        for(int k =0; k<=256; k++){
            int inven = B;
            count = 0;
            cal(inven,k);
            if(result>=count) {
                result=count;
                height = k;
            }
        }
        System.out.println(result + " " + height);

    }
    public static void cal(int inven,int height){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                int diff = height-map[i][j];
                if(diff<0){
                    count += -1*diff*2;
                    inven += -1*diff;
                }
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                int diff = height-map[i][j];
                if(diff>=0) {
                    if (inven < diff) {
                        count = Integer.MAX_VALUE;
                        return;
                    }
                    count += diff;
                    inven -= diff;
                }
            }
        }
    }


}
