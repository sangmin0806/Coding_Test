import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R,C;
    static char[][]map;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        int xcnt = 0;
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='X') xcnt++;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bfs(i,j);
            }
        }
        if(list.size()!= xcnt){
            for (int i = 0; i < list.size(); i++) {
                int[] change = list.get(i);
                map[change[0]][change[1]] = '.';
            }
        }


        StringBuilder sb = new StringBuilder();
        boolean flag;
        ArrayDeque<Integer> rowQue = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            flag = false;
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'X'){
                    flag = true;
                    break;
                }
            }
            if(flag){
                rowQue.add(i);
            }
        }
        ArrayDeque<Integer> colQue = new ArrayDeque<>();
        for (int i = 0; i < C; i++) {
            flag = false;
            for (int j = 0; j < R; j++) {
                if(map[j][i] == 'X'){
                    flag = true;
                    break;
                }
            }
            if(flag){
                colQue.add(i);
            }
        }
        int rowstart = 0;
        int rowend = R-1;
        int colstart = 0;
        int colend = C-1;
        if(!rowQue.isEmpty()){
            rowstart = rowQue.peekFirst();
            rowend = rowQue.peekLast();
        }

        if(!colQue.isEmpty()){
            colstart = colQue.peekFirst();
            colend = colQue.peekLast();
        }

        for (int i = rowstart; i <= rowend; i++) {
            for (int j = colstart; j <= colend; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int row, int col){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { row, col});
        while (!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            int count = 0;
            if(map[crow][ccol]=='X'){
                for (int i = 0; i < 4; i++) {
                    int nrow = crow + dr[i];
                    int ncol = ccol + dc[i];
                    if((nrow<0||ncol<0||nrow>=R||ncol>=C)||(map[nrow][ncol]=='.')){
                        count++;
                    }
                }
            }
            if(count>=3){
                list.add(new int[]{crow,ccol});
            }
        }
    }
}
