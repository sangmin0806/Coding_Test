import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int A;
    static int B;
    static int[] Larr = new int[4];
    static int[] Rarr = new int[4];
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T  = Integer.parseInt(st.nextToken());
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            bfs();

        }
    }
    public static void bfs(){
        Queue<Register> que = new LinkedList<>();
        que.add(new Register(A,"",new StringBuilder()));

        while (!que.isEmpty()){
            Register rg = que.poll();
            visited[rg.n] = true;
            if(rg.n==B){
                System.out.println(rg.pre);
                break;
            }
            int next = D(rg.n);
            if(!visited[next]){
                que.add(new Register(next,"D",rg.pre));
                visited[next] = true;
            }
            next = S(rg.n);
            if(!visited[next]){
                que.add(new Register(next,"S",rg.pre));
                visited[next] = true;
            }
            next = L(rg.n);
            if(!visited[next]){
                que.add(new Register(next,"L",rg.pre));
                visited[next] = true;
            }
            next = R(rg.n);
            if(!visited[next]){
                que.add(new Register(next,"R",rg.pre));
                visited[next] = true;
            }



        }

    }
    public static int D(int n){
        n *=2;
        if(n>9999) n%=10000;
        return n;
    }
    public static int S(int n){
        if(n==0) n=9999;
        else {
            n-=1;
        }
        return n;
    }
    public static int L(int n){
        for (int i = 0; i < 4; i++) {
            int num = 1000;
            for (int j = 0; j < i; j++) {
                num /= 10;
            }
            if(i==0){
                Larr[3] = n/num;
            }
            else {
                Larr[i - 1] = n / num;
            }

            n %=num;

        }
        n=0;
        int num = 1000;
        for (int i = 0; i < 4; i++) {
            n +=Larr[i]*num;
            num/=10;
        }
        return n;
    }
    public static int R(int n){
        for (int i = 0; i < 4; i++) {
            int num = 1000;
            for (int j = 0; j < i; j++) {
                num /= 10;
            }
            if(i==3){
                Rarr[0] = n/num;
            }
            else {
                Rarr[i + 1] = n / num;
            }
            n %=num;
        }
        n=0;
        int num = 1000;
        for (int i = 0; i < 4; i++) {
            n +=Rarr[i]*num;
            num/=10;
        }
        return n;
    }
}
class Register{
    StringBuilder pre = new StringBuilder();
    String str;
    int n;
    public Register(int n,String str, StringBuilder pre){
        this.n = n;
        this.str = str;
        this.pre.append(pre).append(str);
    }
}

