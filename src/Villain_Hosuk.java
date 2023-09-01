import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Villain_Hosuk {
    static int[][] light = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9
    static int count = 0;
    static int N,K,P,X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int[] num = new int[K+1];
        int x = X;
        for (int i = K; i >= 1; i--) {
            num[i] = x%10;
            x = x/10;
        }
        check(num);
        System.out.println(count);
    }
    public static void check( int[] num){
        for (int i = 1; i <= N; i++) { //변경할 숫자를 정한다.현재랑 똑같은건 생각 x
            if(i==X)
                continue;
            if(change(i,num))//바꿔지면 경우의수 +1
                count++;
        }

    }
    public static boolean change(int target, int[] num){
        int[] targets = new int[K+1];
        for (int i = K; i >= 1; i--) {
           targets[i] = target%10;
            target = target/10;
        }

        int diff = 0;
        for (int i = 1; i <= K; i++) {//숫자를 세그먼트로 변경
            for (int j = 0; j <= 6 ; j++) {// 세그먼트 탐색
                if(Math.abs(light[targets[i]][j]-light[num[i]][j])==1){//타겟과의 세그먼트비교하여 몇개 차이나는지 확인
                    diff++;
                }
                if(diff>P)
                    return false;
            }
        }

        return true;
    }
}
