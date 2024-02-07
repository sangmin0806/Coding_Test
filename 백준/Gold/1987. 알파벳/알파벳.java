import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static HashSet<Character> set = new HashSet<>();
    static char[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        set.add(map[0][0]);
        dfs(0,0,1);
        System.out.println(max);
    }

    public static void dfs(int row,int col,int count){
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow<0||ncol<0||nrow>=N||ncol>=M) continue;
            if(set.contains(map[nrow][ncol])) continue;
            set.add(map[nrow][ncol]);
            flag = true;
            dfs(nrow,ncol,count+1);
            set.remove(map[nrow][ncol]);
        }
        if(!flag){
            max = Math.max(max,count);
        }
    }
}
