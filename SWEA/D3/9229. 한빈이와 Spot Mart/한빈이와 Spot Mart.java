import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int max = 0;
            int sum;
            int start =0;
            loop: for (int i = N-1; i >= 0; i--) {
                sum = 0;
                int large = arr[i];
                if(large>=M) continue;
                for (int j = start; j < i; j++) {
                    if(large+arr[j]<M){
                        sum = large+arr[j];
                    }else if(large+arr[j]==M){

                        max = M;
                        break loop;
                    }else {
                        start = j;
                        break;
                    }
                }
                max = Math.max(max,sum);
                if(start>=i) break;
            }
            if(max ==0){
                System.out.println("#"+test+" "+"-1");
            }
            else{
                System.out.println("#"+test+" "+max);
            }
            
        }
    }
}
