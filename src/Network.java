import java.util.*;
public class Network {
        static boolean[][] visited;
        static int answer = 0;
        public int solution(int n, int[][] computers) {
            visited = new boolean[n][n];
            for(int i = 0; i<n; i++){
                if(!visited[i][i])
                    bfs(i,computers);
            }
            return answer;
        }
        public void bfs(int row,int[][] computers){

            Queue<Integer> que = new LinkedList<>();
            que.add(row);
            visited[row][row] = true;
            while(!que.isEmpty()){
                int crow = que.poll();
                for(int i = 0; i<computers.length; i++){
                    if(!visited[crow][i]&&computers[crow][i]==1){
                        visited[crow][i] = true;
                        visited[i][crow] = true;
                        que.add(i);


                    }
                }
            }
            answer++;
        }
        public static void main(String[] args){
            Network sol = new Network();
            int n = 3;
            int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
            int result = sol.solution(n,computers);
            System.out.println(result);
        }
}
