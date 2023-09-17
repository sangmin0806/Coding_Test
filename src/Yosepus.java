import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Yosepus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }
        int num = 0;
        while (!list.isEmpty()){
            num += K-1;
            num = num%list.size();
            if(list.size()==1) {
                sb.append(list.get(num)).append(">");
                break;
            }
            sb.append(list.get(num)).append(", ");
            list.remove(list.get(num));

        }
        System.out.println(sb);
    }
}
