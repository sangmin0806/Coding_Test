import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Pick_Num {
    static int N;
    static int[] arr;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < N+1; i++) {
            boolean[] visited = new boolean[N+1];
            dfs(i,i,visited);
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i: list) {
            System.out.println(i);
        }
    }
    public static void dfs(int start,int init,boolean[] visited){
        if(visited[start])
            return;
        if(arr[start]==init){
            list.add(init);
            return;
        }
        visited[start] = true;

        dfs(arr[start],init,visited);

    }
}
