import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gerrymandering_two {
    static int N;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        int people=0;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                people += map[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    for (int l = 1; l < N + 1; l++) {
                        side(i,j,k,l,people);
                        min = Math.min(min,answer);
                    }
                }
            }
        }
        System.out.println(min);
    }
    public static void side(int x,int y,int d1, int d2,int people){
        if(x+d1+d2>N||y-d1<1||y+d2>N)
            return;
        boolean[][] visited = new boolean[N+1][N+1];
        for (int i = 0; i <= d1; i++) {
            visited[x+i][y-i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            visited[x+i][y+i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            visited[x+d1+i][y-d1+i] = true;
        }
        for (int i = 0; i <= d1; i++) {
            visited[x+d2+i][y+d2-i] = true;

        }
        int fir = 0;
        int sec = 0;
        int third = 0;
        int fourth = 0;
        int fifth = 0;

        for (int i = 1; i < x+d1; i++) {
            boolean flag = false;
            for (int j = 1; j <= y; j++) {
                if(visited[i][j])
                    break;
                people -= map[i][j];
                fir += map[i][j];
            }
        }
        for (int i = 1; i <= x+d2; i++) {
            boolean flag = false;
            for (int j = N; j >y; j--) {
                if(visited[i][j])
                    break;
                people -= map[i][j];
                sec += map[i][j];
            }
        }
        for (int i = x+d1; i <= N; i++) {
            boolean flag = false;
            for (int j = 1; j < y-d1+d2; j++) {
                if(visited[i][j])
                    break;
                people -= map[i][j];
                third += map[i][j];
            }
        }
        for (int i = x+d2+1; i <=N; i++) {
            boolean flag = false;
            for (int j = N; j >= y-d1+d2; j--) {
                if(visited[i][j])
                    break;
                people -= map[i][j];
                fourth += map[i][j];
            }
        }
        fifth = people;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        max =Math.max(Math.max(Math.max(Math.max(fir,sec),third),fourth),fifth);
        min =Math.min(Math.min(Math.min(Math.min(fir,sec),third),fourth),fifth);
        answer = max - min;

    }
}
