import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static String str;
    static int[] nums;
    static int len;
    static char[] op;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        str = br.readLine();
        len = str.length();
        nums = new int[len/2+1];
        op = new char[len/2];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                op[i/2] = c;
                continue;
            }
            nums[i/2] = c-'0';
        }
        dfs(nums[0],0);
        System.out.println(answer);

    }
    public static int cal(int a, int b, char c){
        if(c=='+'){
            return a+b;
        }else if(c=='-'){
            return a-b;
        }else if(c=='*'){
            return a*b;
        }
        return -1;
    }
    public static void dfs(int result,int index){
        if(index>=len/2){
            answer = Math.max(answer,result);
            return;
        }
        int res = cal(result,nums[index+1],op[index]);
        dfs(res,index+1);
        if(index<len/2-1){
            int res2 = cal(result,cal(nums[index+1],nums[index+2],op[index+1]),op[index]);
            dfs(res2,index+2);
        }

    }
}