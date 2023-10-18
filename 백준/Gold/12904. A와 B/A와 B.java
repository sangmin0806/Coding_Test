import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static Boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();
        dfs(T);
        if(!flag){
            System.out.println(0);
        }
    }
    public static void dfs(String str){
        if(str.equals(S)){
            System.out.println(1);
            flag = true;
            System.exit(0);
        }
        if(str.length()<=S.length()){
            return;
        }
        String prestr;
        if(str.charAt(str.length()-1)=='A'){
            prestr = minusA(str);
        }
        else if(str.charAt(str.length()-1)=='B'){
            prestr = minusBAndTurn(str);
        }
        else {
            return;
        }
        dfs(prestr);

    }

    public static String minusBAndTurn(String str) {
        StringBuilder temp = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        temp.append(str).delete(str.length()-1,str.length());
        for (int i = temp.length()-1; i >=0; i--) {
            sb.append(temp.charAt(i));
        }
        return String.valueOf(sb);
    }

    public static String minusA(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).delete(str.length()-1,str.length());
        return String.valueOf(sb);
    }
}
