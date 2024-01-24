import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long sum = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list.add(new Edge(A,B,C));
        }
        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2){
                return Integer.compare(o1.weight,o2.weight);
            }
        });
        int[] parent = new int[V+1];
        for (int i = 1; i < V+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i).A;
            int b = list.get(i).B;
            int c = list.get(i).weight;
            if(!find(a,b,parent)){
                union(a,b,parent);
                sum+=c;
                count++;
            }
            if(count==V-1){
                System.out.println(sum);
                return;
            }
        }

    }
    public static int getParent(int a,int[] parent){
        if(parent[a]==a){
            return parent[a];
        }
        else {
            return parent[a] = getParent(parent[a],parent);
        }
    }
    public static void union(int a, int b,int[] parent){
        a = getParent(a,parent);
        b = getParent(b,parent);
        if(a<b){
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }
    public static boolean find(int a, int b, int[] parent){
        a = getParent(a,parent);
        b = getParent(b,parent);
        if(a==b){
            return true;
        }else {
            return false;
        }

    }
}
class Edge{
    int A;
    int B;
    int weight;
    public Edge(int a, int b, int weight) {
        this.A = a;
        this.B = b;
        this.weight = weight;
    }
}