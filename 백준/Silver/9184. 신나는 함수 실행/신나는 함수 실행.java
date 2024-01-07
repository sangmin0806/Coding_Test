import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a;
    static int b;
    static int c;
    static int [][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[21][21][21];
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a==-1&&b==-1&&c==-1) return;

            int answer = 0;
            if(a<=0||b<=0||c<=0){
                System.out.println("w("+a+", "+b+", "+c+") = "+1);
                continue;
            }
//            for (int i = 0; i < 21; i++) {
//                for (int j = 0; j < 21; j++) {
//                    for (int k = 0; k < 21; k++) {
//                        dp[i][j][k] = w(i,j,k);
//                    }
//                }
//            }
            answer = w(a,b,c);
            System.out.println("w("+a+", "+b+", "+c+") = "+answer);
        }
    }
    public static int w(int a,int b, int c){

        if(a<=0|| b<=0||c<=0){
            return 1;
        }
        if(a>20||b>20||c>20){
            return dp[20][20][20] = w(20,20,20);
        }
        if(dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        if(a<b&&b<c){
            return dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        }
        return dp[a][b][c] = w(a-1,b,c)+ w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
    }
}
