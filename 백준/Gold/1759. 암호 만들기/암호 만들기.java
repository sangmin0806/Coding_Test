import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L,C;
    static char[] arr;
    static int mocount;
    static int jacount;
    static StringBuilder sb = new StringBuilder();
    static char[] answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr =new char[C];
        answer = new char[L];

        visited = new boolean[C];
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        recur(0,0);
        System.out.println(sb);
    }
    public static void recur(int depth,int start) {
        if(depth==L) {
            if(mocount>=1&&jacount>=2){
                for (int i = 0; i < L; i++) {
                    sb.append(answer[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            //if(visited[i]) continue;

            if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u')mocount++;
            else jacount++;
            //visited[i] = true;
            answer[depth] = arr[i];
            recur(depth+1,i+1);
            //visited[i] = false;
            if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u')mocount--;
            else jacount--;
        }
    }
}