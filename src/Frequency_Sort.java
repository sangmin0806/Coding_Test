import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Frequency_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int arr = Integer.parseInt(st.nextToken());
            map.put(arr,map.getOrDefault(arr,0)+1);
        }
        ArrayList<Integer> keylist = new ArrayList<>(map.keySet());
        Collections.sort(keylist, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(map.get(b), map.get(a));
            }
        });
        for (int i = 0; i < keylist.size(); i++) {
            for (int j = 0; j < map.get(keylist.get(i)); j++) {
                System.out.print(keylist.get(i)+" ");
            }
        }


    }
}
