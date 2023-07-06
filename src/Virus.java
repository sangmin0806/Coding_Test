import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus {
    static boolean[] visited;
    static int answer =0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int [N+1][N+1];
        for(int i = 0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        bfs(arr,N);
        System.out.println(answer);
    }
    public static void bfs(int[][] arr, int N){
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[N+1];
        visited[1]= true;
        que.add(1);
        while(!que.isEmpty()){
            int virus = que.poll();
            for(int i = 1; i<N+1;i++){
                if(arr[virus][i]==1&&visited[i]==false){
                    que.add(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }
    }
}
