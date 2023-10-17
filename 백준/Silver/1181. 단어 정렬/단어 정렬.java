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
        int N = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();
        int delcount = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            strings.add(str);
            for (int j = 0; j < i-delcount; j++) {
                if(str.equals(strings.get(j))){
                    strings.remove(j);
                    delcount++;
                    break;
                }
            }
        }
        Collections.sort(strings);
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(),s2.length());
            }
        });
        for(String s : strings){
            System.out.println(s);
        }
    }
}
