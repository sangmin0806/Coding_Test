import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num= Integer.parseInt(br.readLine());
            list.add(num);
        }
        Collections.sort(list,Collections.reverseOrder());
        int pre = list.get(0);

        for (int i = 1; i < N; i++) {
            int current = list.get(i)*(i+1);
            if(pre<current) {
                pre = current;
            }
        }
        System.out.println(pre);
    }
}
