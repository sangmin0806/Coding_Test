import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Shuffle_cards {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] p = new int[N];
        int[] order = new int[N];
        HashSet<Integer> hash1 = new HashSet<>();
        HashSet<Integer> hash2 = new HashSet<>();
        HashSet<Integer> hash3 = new HashSet<>();
        int[] cards = new int[N];
        int[] init = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            cards[i] = i;//초기 카드 놓인 순서
            init[i]=i%3;
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());// 카드 섞는순서
        }
        if(Arrays.equals(init,p)) {// 섞을 필요있는지, 없다면 0
            System.out.println(0);
            return;
        }
        int playernum = 0;
        for (int i = 0; i < N; i++) { // 최종적으로 카드가 이렇게 놓여져 있으면 끝.
            for (int j = 0; j < N; j++) {
                if(p[j]==playernum){
                    if(playernum==0)
                        hash1.add(j);
                    else if(playernum==1)
                        hash2.add(j);
                    else
                        hash3.add(j);
                    p[j] = -1;
                    playernum = (playernum+1)%3;
                    break;
                }
            }
        }
        int result = 0;
        int [] next = new int[N];
        int[] compare = cards.clone();
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();
        HashSet<Integer> h3 = new HashSet<>();
        while (true) {
            if (result != 0 && Arrays.equals(cards, compare)){
                System.out.println(-1);
                return;
            }
            h1.clear();
            h2.clear();
            h3.clear();
            for (int i = 0; i < N; i++) {
                next[order[i]] = cards[i];
            }
            for (int i = 0; i < N; i++) {
                if(i%3==0)
                    h1.add(next[i]);
                else if(i%3==1)
                    h2.add(next[i]);
                else
                    h3.add(next[i]);
            }
            cards = next.clone();
            result++;
            if(h1.equals(hash1)&&h2.equals(hash2)&&h3.equals(hash3))
                break;
        }
        System.out.println(result);
    }


}
