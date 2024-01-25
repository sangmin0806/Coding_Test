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
        List<Keyboard> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            Keyboard kb = new Keyboard(a,b,s);
            list.add(kb);
        }
        Collections.sort(list, new Comparator<Keyboard>() {
            @Override
            public int compare(Keyboard kb1, Keyboard kb2) {
                if(kb1.b==kb2.b){
                    return Integer.compare(kb1.a,kb2.a);
                }
                return Integer.compare(kb1.b,kb2.b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = list.get(i).s;
            sb.append(s);
        }
        System.out.println(sb);
    }
}
class Keyboard{
    int a;
    int b;
    String s;
    public Keyboard(int a, int b, String s){
        this.a = a;
        this.b = b;
        this.s = s;

    }
}
