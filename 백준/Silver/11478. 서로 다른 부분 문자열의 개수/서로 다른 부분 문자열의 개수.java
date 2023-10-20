import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main {
    static String str;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j+i < str.length(); j++) {
                String temp = str.substring(j,j+i+1);
                set.add(temp);
            }

        }
        System.out.println(set.size());
    }
}
