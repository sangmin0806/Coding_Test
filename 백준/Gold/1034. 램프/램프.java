import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static int K;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int zero = 0;
            String str = "";
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    zero++;
                }
                str += map[i][j];

            }
            if(K-zero>=0&&(K-zero)%2==0){
                hashMap.put(str,hashMap.getOrDefault(str,0)+1);
            }
        }
        for(String str : hashMap.keySet()){
            max = Math.max(max,hashMap.get(str));
        }
        System.out.println(max);


    }
}
