import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static boolean[][] visited;
    static int N,M,K;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static class Cell implements Comparable<Cell> {
        int row;
        int col;
        int life;
        int nowlife;

        public Cell(int row, int col, int life) {
            this.row = row;
            this.col = col;
            this.life = life;
            this.nowlife = life;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(o.life,this.life);
        }
    }
    static PriorityQueue<Cell> pq;
    static Queue<Cell> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[N+K][M+K];
            pq = new PriorityQueue<>();
            que = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp!=0){
                        pq.offer(new Cell(K/2+i,K/2+j,temp));
                        visited[K/2+i][K/2+j] = true;
                    }
                }
            }
            while (K-- >0){
                changeStatus();
            }
            System.out.println("#"+test+" "+pq.size());
        }

    }
    public static void changeStatus(){
        while (!pq.isEmpty()){
            Cell c = pq.poll();
            c.nowlife--;
            if(c.nowlife==-1) bfs(c.row,c.col,c.life);// 현재 생명력 0일때 활성화 on -1일때 bfs실행완.
            if(c.life+c.nowlife>0) que.offer(c);// 아직 살아있는 세포는 다시 pq에 넣을꺼니까 일단 que에 저장. 번식후 세포도 죽은걸로 세야함
        }
        while (!que.isEmpty()){
            pq.add(que.poll());//que에 있는거 다시 pq로 옮겨담음
        }
    }
    public static void bfs(int row,int col,int life){
        for (int i = 0; i < 4; i++) {
            int nrow = row+dr[i];
            int ncol = col+dc[i];
            if(visited[nrow][ncol])continue;
            visited[nrow][ncol] = true;
            que.offer(new Cell(nrow,ncol,life));
        }

    }

}
