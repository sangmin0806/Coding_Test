import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pre_Sort {
    static int N;
    static boolean[] visited;
    static List<Integer> list;
    static StringBuilder sb;
    static String prestr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        StringBuilder firstsb = new StringBuilder();
        visited = new boolean[N+1];

        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <N+1 ; i++) {
            sb.append(st.nextToken()).append(" ");
            firstsb.append(i).append(" ");
        }
        if(sb.toString().equals(firstsb.toString())) {
            System.out.println(-1);
            return;
        }
        dfs(2);
        System.out.println(prestr);
    }
    public static void dfs(int num){
        if(list.size()==N){
            StringBuilder dfssb = new StringBuilder();
            for (int i = 0; i <N; i++) {
                dfssb.append(list.get(i)).append(" ");
            }
            if(dfssb.toString().equals(sb.toString())){
                return;
            }
            else {
                prestr = String.valueOf(dfssb);
            }
            System.out.println(prestr);
        }
        for (int i = 1; i < N+1; i++) {
            if(!visited[i]){
                list.add(i);
                visited[i] = true;
                dfs(i);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
