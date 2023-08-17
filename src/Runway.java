import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Runway {
    static int N;
    static int L;
    static int[][] map;
    static int[][] map2;
    static int[][]visited;
    static int[][]visited2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        map2 = new int[N][N];
        visited = new int[N][N];
        visited2 = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                map2[i][j] = map[i][j];
            }
        }
        for(int i = 0; i<N; i++){
            for(int j =0; j<N; j++) {
                xSearch(i,j);
                ySearch(i,j);
            }
        }

        int sum = 0;
        for(int i = 0; i<N; i++){
            int cnt = 1;
            int cnt2 = 1;
            for(int j =0; j<N-1; j++) {
                if (Math.abs(map[i][j] - map[i][j + 1]) > 1 && Math.abs(map2[j][i] - map2[j+1][i]) > 1)
                    break;
                if (map[i][j] == map[i][j + 1]) {
                    cnt++;
                } else if (map[i][j] - map[i][j + 1] == 1 && visited[i][j + 1]==-1) {
                    cnt++;
                } else if (map[i][j + 1] - map[i][j] == 1 && visited[i][j]==1) {
                    cnt++;
                }

                if(map2[j][i]==map2[j+1][i]){
                    cnt2++;
                }
                else if(map2[j][i]-map2[j+1][i]==1 && visited2[j+1][i]==-1){
                    cnt2++;
                }
                else if(map2[j+1][i]-map2[j][i]==1 && visited2[j][i]==1){
                    cnt2++;
                }

            }
            if(cnt==N){
                sum+=1;
            }
            if(cnt2==N) {
                sum += 1;
            }
        }
        System.out.println(sum);

    }
    public static void xSearch(int row,int col){
        if(col==N-1)
            return;
        int downlen = 0;
        int uplen = 0;
        if(map[row][col+1]-map[row][col]==1){
            for(int i = 0; i<L; i++) {
                if(col-i<0||visited[row][col-i] != 0)
                    return;
                if (map[row][col - i] == map[row][col]) {
                    uplen++;
                }
            }
        }
        else if(map[row][col]-map[row][col+1]==1){
            for(int i = 1; i<=L; i++) {
                if(col+i>=N||visited[row][col+i]!=0)
                    return;
                if (map[row][col+i] == map[row][col+1]) {
                    downlen++;
                }
            }
        }
        else{
            return;
        }

        if(uplen>=L){
            for(int i =0; i<L; i++){
                visited[row][col-i] = 1;
            }
        }
        else if(downlen>=L){
            for(int i = 1; i<=L; i++){
                visited[row][col+i] = -1;
            }
        }
    }
    public static void ySearch(int row,int col){
        if(row==N-1)
            return;
        int downlen = 0;
        int uplen = 0;
        if(map2[row+1][col]-map2[row][col]==1){
            for(int i = 0; i<L; i++) {
                if(row-i<0||visited2[row-i][col]!=0)
                    return;
                if (map2[row-i][col] == map2[row][col]) {
                    uplen++;
                }
            }
        }
        else if(map2[row][col]-map2[row+1][col]==1){
            for(int i = 1; i<=L; i++) {
                if(row+i>=N||visited2[row+i][col]!=0)
                    return;
                if (map2[row+i][col] == map2[row+1][col]) {
                    downlen++;
                }
            }
        }
        else{
            return;
        }

        if(uplen>=L){
            for(int i =0; i<L; i++){
                visited2[row-i][col] = 1;
            }
        }
        else if(downlen>=L){
            for(int i = 1; i<=L; i++){
                visited2[row+i][col] = -1;
            }
        }
    }
}
