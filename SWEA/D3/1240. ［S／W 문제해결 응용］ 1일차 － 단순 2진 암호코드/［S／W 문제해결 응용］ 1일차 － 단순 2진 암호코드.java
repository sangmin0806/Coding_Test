import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
class Solution
{
    static int N,M;

    static String[] code = { "0001101",
            "0011001",
            "0010011",
            "0111101",
            "0100011",
            "0110001",
            "0101111",
            "0111011",
            "0110111",
            "0001011"};

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            M = sc.nextInt();
            String inputCode = "";
            boolean flag = false;
            for(int i = 0; i<N; i++){
                String str = sc.next();
                for(int j = M-1 ; j>=0; j--){
                    int c = str.charAt(j)-'0';
                    if(!flag && c == 1){
                        inputCode = str.substring(j-55,j+1);
                        flag = true;
                    }
                }
            }

            int num = 0;
            int[] inputnum = new int[8];
            for(int i = 0; i<8; i++){
                String str = inputCode.substring(num,num+7);
                num += 7;
              
                for(int j = 0; j<10; j++){
                    if(str.equals(code[j])){
                        inputnum[i] = j;
                    }
                }
            }
            
            int answer = 0;
            int odd = 0;
            for(int i = 0; i<8; i++){
                if((i+1)%2==1){
                    odd += inputnum[i];
                }
                else{
                    answer += inputnum[i];
                }
            }
            answer += odd*3;
            int output = 0;
            for (int i = 0; i < 8; i++) {
                output +=inputnum[i];
            }
            if(answer%10==0) System.out.println("#" +test_case+" " +output);
            else System.out.println("#" +test_case+" " +0);

        }
    }
}