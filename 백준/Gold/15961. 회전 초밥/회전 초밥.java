import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,d,k,c;
    static int[] sushi;
    static Queue<Integer> que = new ArrayDeque<>();
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        visited = new int[d+1];
        int max = Integer.MIN_VALUE;
        int count = 0;
        int index = 0;
        int flag= 0;
        for (int i = 0; i < N+k; i++) {

            if(i<N){
                sushi[i] = Integer.parseInt(br.readLine());
            }
            index = i%N;

            if(que.size()<k){
                que.offer(sushi[index]);
                visited[sushi[index]]++;
                if(visited[sushi[index]]==1) count++;
                if(sushi[index]==c) flag++;
            }
            else {
                int head = que.poll();
                visited[head]--;
                if(visited[head]==0) count--;
                if(head==c) flag--;
                que.offer(sushi[index]);
                visited[sushi[index]]++;
                if(visited[sushi[index]]==1) count++;
                if(sushi[index]==c) flag++;
            }

//            System.out.println(Arrays.toString(visited));
//            System.out.println(que);
//            System.out.println(count+ " "+flag);

            if(flag==0) max = Math.max(max,count+1);
            else max = max = Math.max(max,count);

        }
        System.out.println(max);
    }
}
