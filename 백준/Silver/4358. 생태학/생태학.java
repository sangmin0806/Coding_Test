
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<>();
        int cnt = 0;
        while (true){
            String str = br.readLine();

            if(str==null||str.length()==0){
                break;
            }
            cnt++;
            map.put(str,map.getOrDefault(str,0)+1);
        }
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);

        for(Object key: keys){
            int count = map.get(key);
            double per =  (count*100.0)/cnt ;
            System.out.printf("%s %.4f\n",key,per);
        }

    }
}
