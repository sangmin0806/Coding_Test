import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Statistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] num = new int[N];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int most = Integer.MIN_VALUE;
        int mode = 0;
        int count =0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        double avg=0;
        for(int i = 0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,num[i]);
            min = Math.min(min,num[i]);
            sum += num[i];
            avg = (double) sum/N;
            hashMap.put(num[i],hashMap.getOrDefault(num[i],0)+1);
        }

        for(int value :hashMap.values()){
            if(most<value){
                most = value;
            }
        }
        for(int key : hashMap.keySet()){
            if(most==hashMap.get(key)){
                list.add(key);
            }
        }
        Collections.sort(list);

        if(list.size()>=2){
            mode = list.get(1);
        }
        else
            mode = list.get(0);

        Arrays.sort(num);
        int mid = num[N/2];
        int range = max-min;
        int average = (int)Math.round(avg);

        System.out.println(average);
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(range);

    }
}
