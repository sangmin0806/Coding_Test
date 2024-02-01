import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int P;
    static int S;
    static String str;
    static int[]arr;
    static char[] chars;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        arr = new int[4];
        chars = new char[P];
        for (int i = 0; i < P; i++) {
            chars[i] = str.charAt(i);
        }
        for (int i = 0; i < S; i++) {
            if(chars[i]=='A') arr[0]++;
            else if(chars[i]=='C') arr[1]++;
            else if(chars[i]=='G') arr[2]++;
            else if(chars[i]=='T') arr[3]++;
        }
        
        if(a<=arr[0]&&b<=arr[1]&&c<=arr[2]&&d<=arr[3]){
            answer++;
        }
        for (int i = 0; i < P-S; i++) {
            if(chars[i]=='A'&&arr[0]!=0) arr[0]--;
            else if(chars[i]=='C'&&arr[1]!=0) arr[1]--;
            else if(chars[i]=='G'&&arr[2]!=0) arr[2]--;
            else if(chars[i]=='T'&&arr[3]!=0) arr[3]--;

            if(chars[S+i]=='A') arr[0]++;
            else if(chars[S+i]=='C') arr[1]++;
            else if(chars[S+i]=='G') arr[2]++;
            else if(chars[S+i]=='T') arr[3]++;
            
            if(a<=arr[0]&&b<=arr[1]&&c<=arr[2]&&d<=arr[3]){
                answer++;
            }
        }
        System.out.println(answer);
    }
}