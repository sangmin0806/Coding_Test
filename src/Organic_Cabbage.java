import java.util.Scanner;
import java.util.Stack;

public class Organic_Cabbage {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean [][] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0;t<T; t++){
            int count = 0;
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            int arr[][] = new int[N][M];
            for(int i = 0; i<K; i++){
                int X = sc.nextInt();
                int Y = sc.nextInt();
                arr[Y][X] = 1;
            }
            visited = new boolean[arr.length][arr[0].length];
            for(int i = 0; i<N; i++){
                for(int j = 0; j<M; j++){
                    if(arr[i][j]==1 && visited[i][j]==false){
                        dfs(i,j,arr);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    public static void dfs(int y, int x, int[][] arr){
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[] {y,x});
        visited[y][x] = true;
        while(!stack.isEmpty()){
            int[] current = stack.pop();
            int cx = current[1];
            int cy = current[0];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0||ny<0||nx>=arr[0].length||ny>=arr.length)
                    continue;
                if(arr[ny][nx]==1 && visited[ny][nx]==false) {
                    stack.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
