import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(str.charAt(i)-'0');
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i2,i1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i: list){
            sb.append(i);
        }
        System.out.println(sb);

    }
}
