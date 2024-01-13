import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] crane = new int[N];
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int box = Integer.parseInt(st.nextToken());
            list.add(box);
        }
        Arrays.sort(crane);
        Collections.sort(list);
        int time =0;
        int boxIndex = M-1;
        if(crane[N-1]<list.get(boxIndex)){
            System.out.println(-1);
            return;
        }
        loop: while (true){
            time++;
            boxIndex = list.size()-1;
            for (int i =N-1; i >=0; i--) {
                if(crane[i]>=list.get(boxIndex)){
                    list.remove(boxIndex);

                    boxIndex--;
                    if(list.size()==0&&boxIndex==-1) break loop;
                    if(list.size()!=0&&boxIndex==-1) break;
                }
                else {
                    boxIndex--;
                    i++;
                    if(boxIndex==-1) break;
                }

            }
        }
        System.out.println(time);
    }
}
