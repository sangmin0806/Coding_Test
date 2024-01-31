import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int s,N,K,R1,R2,C1,C2;
    static List<obj> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        recursive(s,(int)Math.pow(N,s),K*(int)Math.pow(N,s-1),0,0);
        int[][] map = new int[R2-R1+1][C2-C1+1];

        for (int i = R1; i < R2+1; i++) {
            for (int j = C1; j < C2+1; j++) {
                for (int k = 0; k < list.size(); k++) {
                    obj obj = list.get(k);
                    long row = obj.row;
                    long col = obj.col;
                    int klen = obj.k;

                    if(row<=i&&i<row+klen&&col<=j&&j<col+klen) {
                        map[i-R1][j-C1] = 1;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R2-R1+1; i++) {
            for (int j = 0; j < C2-C1+1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void recursive(int time,long n,int k,long row,long col){
        if(time==0){
            return;
        }
        long len = n/N;
        
        list.add(new obj(time, row+(n-k)/2, col+(n-k)/2,k));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long nrow = row+len*i;
                long ncol = col+len*j;
                if(nrow+len-1>=R1&&nrow<=R2&&ncol+len-1>=C1&&ncol<=C2) {
                    recursive(time-1, len, k/N,nrow ,ncol);
                }
            }
        }

    }
}

class obj{
    int time;
    long row;
    long col;
    int k;
    public obj(int time,long row,long col,int k) {
        this.time = time;
        this.row = row;
        this.col = col;
        this.k = k;
    }
}
