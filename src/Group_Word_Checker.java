import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Group_Word_Checker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            flag = false;
            for (int j = 0; j < str[i].length(); j++) {
                if(j>0 && str[i].charAt(j) != str[i].charAt(j-1)) {
                    for (int k = 0; k < j; k++) {
                        if(str[i].charAt(k)==str[i].charAt(j)) {
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag && j==str[i].length()-1)
                    count++;
            }

        }
        System.out.println(count);

    }
}
