import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Part_Time_kangho {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] tips = new Integer[N];
        for (int i = 0; i < N; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips,Collections.reverseOrder());
        long result = 0;
        for (int i = 0; i < N; i++) {
            long tip = tips[i]-i;
            if(tip<0)
                continue;
            result += tip;
        }
        System.out.println(result);
    }
}
