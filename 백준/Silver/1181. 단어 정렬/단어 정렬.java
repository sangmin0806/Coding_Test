import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();
        Set<String> seenStrings = new HashSet<>(); // 중복을 검사하기 위한 HashSet
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!seenStrings.contains(str)) {
                strings.add(str);
                seenStrings.add(str);
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
