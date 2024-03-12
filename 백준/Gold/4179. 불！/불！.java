import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int R;
    static int C;
    static char[][] map;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};
    static boolean flag = false;
    static int time =0;
    static Queue<int[]> que = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='J') {
                    que.add(new int[] {i,j,0});
                }
                else if(map[i][j]=='F') {
                    que.offer(new int[] {i,j,1});
                }
            }
        }
        bfs();
        if(flag) {
            System.out.println(time);
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
    }
    public static void bfs() {
        Queue<int[]> temp = new ArrayDeque<>();
        int[] tempArr = new int[2];
        int[] current;
        while(!que.isEmpty()) {
            int size = que.size();
            time++;
            for (int q = 0; q < size; q++) {
                current = que.poll();
                if(current[2]==0) {
                    if(current[0]==0||current[0]==R-1||current[1]==0||current[1]==C-1) {
                        flag =true;
                        return;
                    }
                    temp.offer(current);
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nrow = current[0]+dr[i];
                    int ncol = current[1]+dc[i];
                    if(nrow<0||ncol<0||nrow>=R||ncol>=C)continue;
                    if(current[2]==1) {
                        if(map[nrow][ncol]=='.'||map[nrow][ncol]=='J') {
                            map[nrow][ncol] = 'F';
                            que.offer(new int[] {nrow,ncol,1});
                        }
                    }
                }

            }
            while (!temp.isEmpty()){
                 tempArr = temp.poll();
                for (int i = 0; i < 4; i++) {
                    int nrow = tempArr[0]+dr[i];
                    int ncol = tempArr[1]+dc[i];
                    if(nrow<0||ncol<0||nrow>=R||ncol>=C)continue;
                    
                    if(map[nrow][ncol]=='.') {
                        map[nrow][ncol] = 'J';
                        que.offer(new int[]{nrow,ncol,0});
                    }
                }

            }
            

        }
    }
}