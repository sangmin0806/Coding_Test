import java.util.*;

public class DFS_BFS {
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        arr = new int[N+1][N+1];

        for(int i = 0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b]= 1;
            arr[b][a]= 1;
        }
        visited = new boolean[N+1];
        visited[V] = true;
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        visited[V] = true;
        bfs(V);

    }
    public static void dfs(int V){
        System.out.print(V+" ");
        if(V==arr.length)
            return;

        for(int i = 0; i<arr.length;i++) {
            if (arr[V][i] == 1 && visited[i] == false) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
    public static void bfs(int V){
        Queue<Integer> que = new LinkedList<>();
        que.add(V);
        System.out.print(V+" ");
        while (!que.isEmpty()){
            int temp = que.poll();
            for(int i = 0; i<arr.length; i++){
                if(arr[temp][i]==1 && visited[i] == false){
                    visited[i] = true;
                    que.add(i);
                    System.out.print(i+" ");
                }
            }
        }

    }
}
