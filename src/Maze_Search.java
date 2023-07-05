import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze_Search {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] visited;
    static int answer = 1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        visited = new int[N][M];

        for(int i = 0; i<N; i++){
            String s = sc.next();
            for(int j = 0; j<M; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        bfs(arr);
        answer = visited[arr.length-1][arr[0].length-1];
        System.out.println(answer);
    }
    public static void bfs(char[][] arr){
        Queue<int[]> que = new LinkedList<>();
        visited[0][0] = 1;
        int x = 0;
        int y = 0;
        que.add(new int[]{x,y});
        while (!que.isEmpty()){
            int [] current = que.poll();
            int cx = current[0];
            int cy = current[1];
            if(cx==arr[0].length-1 && cy==arr.length-1)
                return;
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0 || nx>arr[0].length-1 || ny<0 || ny>arr.length-1)
                    continue;
                if(visited[ny][nx]==0 && arr[ny][nx]=='1') {
                    que.add(new int[]{nx, ny});
                    visited[ny][nx]=visited[cy][cx]+1;
                }
            }
        }
    }
}
