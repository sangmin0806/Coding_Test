import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<int[]> list = new ArrayList<>();
    static int bottomIndex;
    static int max = Integer.MIN_VALUE;
    static int leafNode =0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        bottomIndex = 0;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int top = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.add(new int[]{top,bottom,value});
            bottomIndex = top;
        }
        bottomIndex += 1;
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1,0);
        visited = new boolean[N+1];
        visited[leafNode] = true;
        leafDfs(leafNode,0);
        System.out.println(max);
    }
    public static void dfs(int num,int sum){
        if(max<=sum){
            max = sum;
            leafNode = num;
        }

        for (int i = 0; i < N-1; i++) {
            if(list.get(i)[0]==num&&!visited[list.get(i)[1]]){
                visited[list.get(i)[1]] = true;
                dfs(list.get(i)[1],sum+list.get(i)[2]);
            }
        }
    }
    public static void leafDfs(int num,int sum){
        if(max<=sum){
            max = sum;
        }

        for (int i = 0; i < N-1; i++) {
            if(list.get(i)[0]==num&&!visited[list.get(i)[1]]){
                visited[list.get(i)[1]] = true;
                leafDfs(list.get(i)[1],sum+list.get(i)[2]);
            }
            else if(list.get(i)[1]==num&&!visited[list.get(i)[0]]){
                visited[list.get(i)[0]] = true;
                leafDfs(list.get(i)[0],sum+list.get(i)[2]);
            }
        }
    }
}
