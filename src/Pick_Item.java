import java.util.*;
public class Pick_Item {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int count = 0;
    static boolean[][] visited;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int row = 0;
        int col = 0;
        for(int i = 0; i<rectangle.length; i++){
            row = Math.max(row,rectangle[i][3]);
            col = Math.max(col,rectangle[i][2]);
        }
        row = 2*(row+1);
        col = 2*(col+1);
        map = new int[row][col];
        visited = new boolean[row][col];
        for(int k = 0; k<rectangle.length;k++){
            for(int i =2*rectangle[k][1]; i<=2*rectangle[k][3]; i++){
                for(int j =2*rectangle[k][0] ; j<=2*rectangle[k][2]; j++){
                    map[i][j] = 1;

                }
            }

        }
        for(int k = 0; k<rectangle.length;k++){
            for(int i =2*rectangle[k][1]+1; i<2*rectangle[k][3]; i++){
                for(int j =2*rectangle[k][0]+1 ; j<2*rectangle[k][2]; j++){
                    map[i][j] = 0;

                }
            }

        }


        bfs(rectangle,characterX,characterY,itemX,itemY);
        answer = count/2;
        return answer;
    }
    public void bfs(int[][] rectangle, int characterX, int characterY,int itemX, int itemY){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {2*characterY,2*characterX});
        visited[2*characterY][2*characterX] = false;
        while(!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];

            if(crow==(2*itemY)&&ccol==(itemX*2)){
                count = map[crow][ccol];
                return;
            }
            for(int i = 0; i<4; i++){
                int nrow = crow+dx[i];
                int ncol = ccol+dy[i];
                if(nrow<0||ncol<0||nrow>=map.length||ncol>=map[0].length)
                    continue;
                if(map[nrow][ncol]==0)
                    continue;
                if(!visited[nrow][ncol]){
                    visited[nrow][ncol] = true;
                    map[nrow][ncol] = map[crow][ccol]+1;
                    que.add(new int[]{nrow,ncol});
                }

            }
        }
    }

    public static void main(String[] args) {
        Pick_Item sol = new Pick_Item();
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int result = sol.solution(rectangle,1,3,7,8);
        System.out.println(result);
    }

}
