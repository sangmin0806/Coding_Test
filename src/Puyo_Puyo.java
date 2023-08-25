import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Puyo_Puyo {
    static char[][] map;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int answer = 0;
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            str = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);

            }
        }
        while(true) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j]!='.') {
                        bfs(i, j);
                    }
                }
            }
            if (flag) {//연쇄가 일어났으면 +1 안일어나면 끝
                answer++;
                flag = false;
                move();
            }
            else {
                break;
            }
//            for (int i = 0; i < 12; i++) {
//                for (int j = 0; j < 6; j++) {
//                    System.out.print(map[i][j] +" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        System.out.println(answer);


    }
    public static void move(){
        for (int i = 10; i >=0 ; i--) {
            for (int j = 0; j < 6; j++) {
                if(map[i][j]=='.')
                    continue;
                if(map[i+1][j]=='.'){
                    int a = i;
                    while(true){
                        if(a==11)
                            break;
                        if(map[a+1][j]=='.') {
                            map[a + 1][j] = map[a][j];
                            map[a][j] = '.';
                            a++;
                        }
                        else
                            break;
                    }

                }

            }
        }
    }
    public static void bfs(int row, int col){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col});
        List<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[12][6];
        int count = 0;
        while (!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];

            for (int i = 0; i < 4; i++) {
                int nrow = crow + dr[i];
                int ncol = ccol + dc[i];
                if(nrow<0||ncol<0||nrow>=12||ncol>=6)
                    continue;
                if(visited[nrow][ncol])
                    continue;
                if(map[nrow][ncol] != '.' && (map[nrow][ncol]== map[crow][ccol])){
                    count++;
                    list.add(new int[]{nrow,ncol});
                    que.add(new int[] {nrow,ncol});
                    visited[nrow][ncol] = true;
                }

            }
        }
        if(count>=4){
            flag = true; //연쇄 일어남
            for (int j = 0; j < list.size(); j++) {
                int r = list.get(j)[0];
                int c = list.get(j)[1];
                map[r][c] = '.';
            }
        }
    }
}
