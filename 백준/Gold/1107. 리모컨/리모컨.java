import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static String N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken();
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int[] errBt = new int[M];
        if(M != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                errBt[i] = Integer.parseInt(st.nextToken());
            }
        }
        int target = Integer.parseInt(N);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 999999; i++) {
            boolean err = false;
            String str = String.valueOf(i);
            int len = str.length();
            loop:for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < M; k++) {
                    if(str.charAt(j)-'0'==errBt[k]){
                        err = true;
                        break loop;
                    }
                }
            }
            if(!err){
                min = Math.min(Math.abs(target-i)+len,min);
            }
        }
        
        min = Math.min(Math.abs(target-100),min);
        System.out.println(min);

    }
}
