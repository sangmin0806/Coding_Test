import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int [] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = 1;
            for (int j = 0; j < N; j++) {
                if(i==j) continue;
                if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]){
                    answer[i]++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(answer[i]+" ");
        }
    }
}
