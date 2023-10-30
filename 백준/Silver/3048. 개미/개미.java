import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        char[] chars = new char[N1+N2];
        String str = br.readLine();
        for (int i = 0; i < N1; i++) {
            chars[i] = str.charAt(N1-1-i);
            set1.add(chars[i]);
        }
        str = br.readLine();
        for (int i = 0; i < N2; i++) {
            chars[N1+i] = str.charAt(i);
            set2.add(chars[N1+i]);
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            List<int[]> list = new ArrayList<>();
            for (int j = N1+N2-2; j >=0 ; j--) {
                if(set1.contains(chars[j])&&set2.contains(chars[j+1])){
                    list.add(new int[]{j,j+1});
                }
            }
            for (int j = 0; j < list.size(); j++) {
                char temp = chars[list.get(j)[0]];
                chars[list.get(j)[0]] = chars[list.get(j)[1]];
                chars[list.get(j)[1]] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            sb.append(c);
        }
        System.out.println(sb);

    }
}
