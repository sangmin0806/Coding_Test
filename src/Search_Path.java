import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Search_Path {
    static int N;
    static boolean flag = false;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int[][] answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean[] visited = new boolean[N];
                dfs(i,j,0,visited);
                if(flag){
                    answer[i][j] = 1;
                }
                flag = false;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void dfs(int start, int end,int count,boolean[] visited){
        if(count>0&&start==end){
            flag = true;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]&&map[start][i]==1){
                visited[i]=true;
                dfs(i,end,count+1,visited);
            }
        }

    }
}
