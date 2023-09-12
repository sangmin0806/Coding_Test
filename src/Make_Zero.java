import javax.naming.ldap.PagedResultsResponseControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Make_Zero {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            dfs(1,new char[N]);
            System.out.println();
        }
    }
    public static void dfs(int count, char[] arr){
        if(count==N){
            if(result(arr)){
                System.out.print(1);
                for (int i = 1; i < N; i++) {
                    System.out.print(arr[i]);
                    System.out.print(i+1);
                }
                System.out.println();
            }
            return;
        }
        arr[count] = ' ';
        dfs(count+1, arr);
        arr[count] = '+';
        dfs(count+1, arr);
        arr[count] = '-';
        dfs(count+1, arr);
    }
    public static boolean result(char[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append('+').append(1);
        for (int i = 1; i < N; i++) {
            sb.append(arr[i]).append(i+1);
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < 2*N; i++) {
            String  str = sb.substring(i,i+2);
            if(str.charAt(0)==' '){
                temp.append(str.charAt(1));
            }
            else {
                temp.append(str);
            }
            i++;
        }
        int sum =0;
        String s = String.valueOf(temp);
        StringTokenizer st = new StringTokenizer(s,"+|-",true);
        while (st.hasMoreElements()){
            String t = st.nextToken();
            if(t.equals("+")){
                sum += Integer.parseInt(st.nextToken());
            }
            else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        if(sum == 0){
            return true;
        }
        return false;
    }
}
