import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<info> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            list.add(new info(age,str));
        }
        Collections.sort(list, new Comparator<info>() {
            @Override
            public int compare(info o1, info o2) {
                return Integer.compare(o1.age,o2.age);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(info o : list){
            sb.append(o.age).append(" ").append(o.name).append("\n");
        }
        System.out.println(sb);
    }
}
class info{
    int age;
    String name;
    public info(int age,String name){
        this.age = age;
        this.name = name;
    }
}
