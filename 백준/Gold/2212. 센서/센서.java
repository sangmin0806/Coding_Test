import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int[] sensor = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        if(K>=N){
            System.out.println(0);
            return;
        }
        Arrays.sort(sensor);
        int[] diff = new int[N-1];
        for (int i = 0; i < N -1; i++) {
            diff[i] = sensor[i+1]-sensor[i];
        }
        Arrays.sort(diff);
        int answer = sensor[N-1]-sensor[0];
        for (int i = 0; i < K-1; i++) {
            answer -= diff[N-2-i];
        }
        System.out.println(answer);
    }
}
