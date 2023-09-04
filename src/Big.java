import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Big {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x,y});
        }
        //자신보다  더 큰 덩치의 사람 k명이면 덩치 등수는 k+1
        int len = list.size();
        for(int i =0 ; i<len; i++){
            int k = 0;
            for (int j = 0; j < len; j++) {
                if(i==j)
                    continue;
                if(list.get(i)[0]<list.get(j)[0]&&list.get(i)[1]<list.get(j)[1]){
                    k++;
                }
            }
            System.out.print(k+1+" ");
        }
    }
}
