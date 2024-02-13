import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] location;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        location = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(location);

        int minus = 0;
        for (int i = 0; i < M; i++) {
            if(minus>=N) {
                break;
            }
            if(location[minus]<0) {
                minus++;
            }
        }
        int plus = N-1;
        for (int i = 0; i < M; i++) {
            if(plus<0){
                break;
            }
            if(location[plus]>0) {
                plus--;
            }

        }
        boolean pl = false;
        int index = minus;
        if(Math.abs(location[N-1])>=Math.abs(location[0])){
            pl = true;
            index = plus;
        }

        if(pl){
            answer += Math.abs(location[N-1]);
        }
        else {
            answer += Math.abs(location[0]);
        }

        int count = M;
        boolean flag = false;
        //System.out.println(Arrays.toString(location));
        //System.out.println(minus);
        while (true){
            if(index>=N||index<0) break;
            if(flag&&pl&&location[index]<0||flag&&!pl&&location[index]>0) break;
            if(!flag&&pl&&location[index]<0){
                index = 0;
                pl = false;
                flag = true;
                count = M;
            }
            else if(!flag&&!pl&&location[index]>0){
                index = N-1;
                pl = true;
                flag = true;
                count = M;
            }
            if(count==M) {
                count = 0;
                answer += Math.abs(location[index]*2);
                //System.out.println(answer+" "+index);
            }
            if(pl){
                index--;
            }
            else{
                index++;
            }
            count++;

        }

        System.out.println(answer);


    }
}