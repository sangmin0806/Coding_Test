import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sick_Knight {
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int count = 1;
        if(N<3){
            if(N==1) {
                System.out.println(count);
                return;
            }
            count = 1+(M-1)/2;
            if(count>4){
                count = 4;
            }
        }
        else {
            if(M<7){
                count = M;
                if(count>4){
                    count = 4;
                }
            }
            else {
                count = 5+M-1-6;
            }
        }
        System.out.println(count);
    }
}
