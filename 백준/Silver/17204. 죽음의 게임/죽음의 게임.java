import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static boolean[] visited;
    static int[] person;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        person = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            person[i] = Integer.parseInt(st.nextToken());
        }
        visited[0] = true;
        dfs(person[0]);

    }
    public static void dfs(int num){
        
        if(visited[num]){
            System.out.println(-1);
            return;
        }
        count++;
        if(num == K){
            System.out.println(count);
            return;
        }
        visited[num] = true;
        dfs(person[num]);
    }
}
