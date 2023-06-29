import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Divide_The_Power_Grid {
    static int[][] graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int [n+1][n+1];

        for(int i =0; i<wires.length;i++){
            int from = wires[i][0], to = wires[i][1];
            graph[from][to]=1;
            graph[to][from]=1;
        }

        for(int i=0; i<wires.length; i++){
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 0;
            graph[to][from] = 0;
            answer = Math.min(answer,bfs(n,from));
            graph[from][to] = 1;
            graph[to][from] = 1;

        }
        return answer;
    }
    public static int bfs(int n, int from){
        boolean[] visited = new boolean[n+1];
        int count = 1;
        Queue<Integer> que = new LinkedList<Integer>();
        visited[from] = true;
        que.add(from);


        while(!que.isEmpty()){
            int temp = que.poll();
            for(int i =1; i<=n; i++){
                if(graph[temp][i]==1&&!visited[i]){
                    visited[i] = true;
                    que.add(i);
                    count++;
                }
            }
        }
        return (int)Math.abs(count-(n-count));
    }
    public static void main(String[] args) {
        Divide_The_Power_Grid solutionInstance = new Divide_The_Power_Grid();
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int result = solutionInstance.solution(9,wires);
        System.out.println("result = "+result);
    }
}
