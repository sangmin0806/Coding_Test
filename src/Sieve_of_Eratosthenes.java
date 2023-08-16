import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sieve_of_Eratosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] list = new int[N+1];
        for (int i = 2; i <= N; i++) {
            list[i] = i;
        }
        int cnt = 0;
        for(int i = 2; i<=N; i++){
            int count = 0;
            if(i == 2){
                count = 1;
            }
            for(int j = 2; j<i; j++){
                if(i/j!=0){
                    count++;
                    break;
                }
            }
            if(count==1){
                for(int k = 1; i*k <= N;k++){
                    if(list[i*k]!=0){
                        cnt++;
                        if(cnt == K){
                            System.out.println(list[i*k]);
                            return;
                        }
                        list[i*k] = 0;
                    }


                }
            }

        }
    }
}
