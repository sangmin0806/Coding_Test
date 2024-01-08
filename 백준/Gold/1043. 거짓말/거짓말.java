import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int knowNum = Integer.parseInt(st.nextToken());
        HashSet<Integer> knows = new HashSet<>();
        for (int i = 0; i < knowNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            knows.add(num);
        }
        int[][] party = new int[M][50];
        boolean[] check = new boolean[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partyNum; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
                if(knows.contains(party[i][j])){
                    check[i] = true;
                }
            }
            if(check[i]){
                for (int j = 0; j < partyNum; j++) {
                    knows.add(party[i][j]);
                }
            }
        }


        while (true){
            boolean flag = false;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 50; j++) {
                    if(!check[i]&&knows.contains(party[i][j])){
                        check[i] = true;
                        flag = true;
                        break;
                    }
                }
                if(check[i]){
                    for (int j = 0; j < 50; j++) {
                        if(party[i][j]==0) break;
                        knows.add(party[i][j]);
                    }
                }
            }
            if(!flag) break;
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if(!check[i]){
                count++;
            }

        }

        System.out.println(count);


    }
}
