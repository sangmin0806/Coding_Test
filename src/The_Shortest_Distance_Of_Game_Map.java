import java.util.*;
public class The_Shortest_Distance_Of_Game_Map {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(visited,maps);
        answer = visited[maps.length-1][maps[0].length-1];
        if(answer==0){
            answer = -1;
            return answer;
        }
        return answer;
    }
    public void bfs(int[][] visited,int[][] maps){
        visited[0][0] = 1;
        int x = 0;
        int y = 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});

        while(!que.isEmpty()){
            int[] current = que.poll();
            int cX = current[0];
            int cY = current[1];

            for(int i = 0;i<4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                if(nX<0||nY<0||nX>=maps.length||nY>=maps[0].length)
                    continue;
                if(visited[nX][nY]==0&&maps[nX][nY]==1){
                    visited[nX][nY] = visited[cX][cY]+1;
                    que.add(new int[]{nX,nY});
                }
            }
        }
    }
    public static void main(String[] args) {
        The_Shortest_Distance_Of_Game_Map sol = new The_Shortest_Distance_Of_Game_Map();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int result = sol.solution(maps);
        System.out.println(result);
    }
}
