import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Stand_In_One_Line {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int index = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 0; j < N; j++) {
                if(arr[j]!=0)
                    continue;
                else
                    count++;
                if(count==index+1){
                    arr[j] = i;
                    break;
                }
            }

        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");

        }

    }
}
