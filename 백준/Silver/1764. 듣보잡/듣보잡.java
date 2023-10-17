import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] heard = new String[N];
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < N; i++) {
            heard[i] = br.readLine();
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            seen.add(str);
        }
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(seen.contains(heard[i])){
                list.add(heard[i]);
                count++;
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for(String s : list){
            System.out.println(s);
        }
    }
}
