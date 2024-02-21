import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int L,C;
    static char[] arr;
    static StringBuilder sbanswer = new StringBuilder();
    static LinkedHashSet<String> hashSet = new LinkedHashSet<>();
    static char[] answer;
    static boolean[] visited;
    static char[] temp ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr =new char[C];
        answer = new char[L];
        temp = new char[L];
        visited = new boolean[C];
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        recur(0);
        for(String str :hashSet) {
            sbanswer.append(str).append("\n");
        }
        System.out.println(sbanswer);
    }
    public static void recur(int depth) {
        if(depth==L) {
            StringBuilder sb = new StringBuilder();
            int mocount = 0;
            int jacount = 0;
            for (int i = 0; i < L; i++) {
                if(answer[i]=='a'||answer[i]=='e'||answer[i]=='i'||answer[i]=='o'||answer[i]=='u')mocount++;
                else jacount++;
                temp[i] = answer[i];
            }
            if(mocount>=1&&jacount>=2){
                Arrays.sort(temp);
                for (int i = 0; i < L; i++) {
                    sb.append(temp[i]);
                }
                hashSet.add(sb.toString());
            }
            return;
        }
        for (int i = depth; i < C; i++) {
            if(visited[i]) continue;
            answer[depth] = arr[i];
            visited[i] = true;
            recur(depth+1);
            visited[i] = false;
        }
    }
}