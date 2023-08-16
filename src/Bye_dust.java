import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bye_dust {
    static int R;
    static int C;
    static int T;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        boolean first = true;
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        for (int k = 0; k < T; k++) {
            int[][] copymap = new int[R][C];
            que.clear();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != 0 && map[i][j] != -1) {
                        que.add(new int[]{i, j});
                    }

                    copymap[i][j] = map[i][j];
                }
            }
            bfs(que,copymap);
            for (int t = 2; t < R - 2; t++) {
                if (map[t][0] != -1)
                    continue;
                if (first) {
                    first = false;
                    int pre = map[t][1];
                    map[t][1] = 0;
                    for (int i = 1; i < C - 1; i++) {
                        int next = map[t][i + 1];
                        map[t][i + 1] = pre;
                        pre = next;
                    }
                    for (int i = t; i > 0; i--) {
                        int next = map[i - 1][C - 1];
                        map[i - 1][C - 1] = pre;
                        pre = next;
                    }
                    for (int i = C - 1; i > 0; i--) {
                        int next = map[0][i - 1];
                        map[0][i - 1] = pre;
                        pre = next;
                    }
                    for (int i = 0; i < t; i++) {
                        int next = map[i + 1][0];
                        map[i + 1][0] = pre;
                        pre = next;
                    }
                    map[t][0] = -1;
                } else {
                    first = true;
                    int pre = map[t][1];
                    map[t][1] = 0;
                    for (int i = 1; i < C - 1; i++) {
                        int next = map[t][i + 1];
                        map[t][i + 1] = pre;
                        pre = next;
                    }
                    for (int i = t; i < R - 1; i++) {
                        int next = map[i + 1][C - 1];
                        map[i + 1][C - 1] = pre;
                        pre = next;
                    }
                    for (int i = C - 1; i > 0; i--) {
                        int next = map[R - 1][i - 1];
                        map[R - 1][i - 1] = pre;
                        pre = next;
                    }
                    for (int i = R - 1; i > t; i--) {
                        int next = map[i - 1][0];
                        map[i - 1][0] = pre;
                        pre = next;
                    }
                    map[t][0]=-1;
                }

            }

        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum+2);
    }
    public static void bfs(Queue<int[]> que,int[][] copymap){

        while(!que.isEmpty()){
            int count = 0;
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            int temp = 0;
            for(int i = 0; i<4; i++){
                int nrow = crow + dr[i];
                int ncol = ccol + dc[i];

                if(nrow<0||ncol<0 ||nrow>=R||ncol>=C)
                    continue;
                if(map[nrow][ncol]==-1)
                    continue;
                temp += copymap[crow][ccol]/5;
                map[nrow][ncol] += copymap[crow][ccol]/5;
                count++;
            }
            if(count != 0){
                map[crow][ccol] -= temp ;
            }

        }

    }
}
