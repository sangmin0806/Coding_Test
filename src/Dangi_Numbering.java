import java.util.*;

public class Dangi_Numbering {
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int num = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        int count = 0;
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            for(int j = 0; j< N; j++){
                if(arr[i][j]=='1' && visited[i][j]==false){
                    dfs(i,j,arr,visited);
                    list.add(num);
                    num = 1;
                    count++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for(int i = 0; i<list.size(); i++)
            System.out.println(list.get(i));
    }
    public static void dfs(int a, int b,char[][] arr,boolean[][] visited){
        int row = a;
        int col = b;
        visited[row][col] = true;
            for(int i = 0; i<4; i++){
                int nx = row + dx[i];
                int ny = col + dy[i];
                if(nx<0||ny<0||nx>=arr[0].length||ny>=arr.length)
                    continue;
                if(arr[nx][ny]=='1' && visited[nx][ny]==false) {
                    visited[nx][ny] = true;
                    num++;
                    dfs(nx, ny, arr, visited);
                }
            }
    }
}


