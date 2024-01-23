import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int function = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(function==0){
                Union(a,b);
            }else {
                find(a,b);
            }
        }
        System.out.println(sb);
    }
    public static int getParent(int a){
        if(parent[a]==a) return parent[a];

        return parent[a] = getParent(parent[a]);

    }
    public static void Union(int a,int b){
        a = getParent(a);
        b = getParent(b);
        if(a<b){
            parent[b] = a;
        }else {
            parent[a] = b;
        }
    }
    public static void find(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a==b) sb.append("YES").append("\n");
        else sb.append("NO").append("\n");
    }
}
