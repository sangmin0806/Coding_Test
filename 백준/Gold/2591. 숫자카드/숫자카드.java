import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str = "";
    static int N1;
    static int N2;
    static int len;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        len = str.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            N1 = str.charAt(i-1)-'0';
            N2 = (str.charAt(i-2)-'0')*10+str.charAt(i-1)-'0';
            if(N1==0&&N2<=34){
                dp[i] = dp[i-2];
                continue;
            }
            if(str.charAt(i-2)-'0'==0||N2>34){
                dp[i] = dp[i-1];
            }
            else {
                dp[i] = dp[i-1]+dp[i-2];
            }
        }


        System.out.println(dp[len]);
    }

}

