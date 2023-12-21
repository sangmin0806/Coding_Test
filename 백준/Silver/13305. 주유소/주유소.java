import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] len = new long[N-1];
        long[] gas = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }
        long pre = gas[0];
        long charge = 0;
        long sum = 0;
        for (int i = 0; i < N-1; i++) {
            if(pre>gas[i]){
                pre = gas[i];
            }
            charge = pre*len[i];
            sum += charge;
        }
        System.out.println(sum);
    }
}
