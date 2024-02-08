

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static List<Edge>[] list;
    static int[] cost;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N+1];
        Arrays.fill(cost,INF);
        list = new List[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e,v));
            list[e].add(new Edge(s,v));
        }
        dijkstra(1);
        System.out.println(cost[N]);
    }
    public static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return Integer.compare(e1.val,e2.val);
            }
        });
        pq.add(new Edge(start,0));
        cost[start] = 0;
//        for (int i = 1; i <=N ; i++) {
//            for (int j = 0; j < list[i].size(); j++) {
//                System.out.println("시작노드: "+i+"끝노드: "+ list[i].get(j).end+"가중치: "+list[i].get(j).val);
//            }
//        }
        while (!pq.isEmpty()){
            Edge current = pq.poll();
            for(Edge next : list[current.end]){
               // System.out.println("현재 노드: "+current.end+"비용"+cost[current.end]);
                if(cost[next.end]>cost[current.end]+next.val){
                    cost[next.end] = cost[current.end]+next.val;
                    pq.add(new Edge(next.end,cost[next.end]));
                }
            }
        }
    }

}
class Edge{
    int end;
    int val;
    public Edge(int end,int val){
        this.end = end;
        this.val = val;
    }
}
