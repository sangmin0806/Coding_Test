import java.util.Scanner;


class Solution
{
	static char[] arr;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();
            int len = str.length();
            arr = new char[len];
            for (int i = 0; i < len; i++) {
                arr[i] = str.charAt(i);
            }
            int count = 0;
            boolean flag = false;
            for (int i = 0; i < len; i++) {
                if(!flag&&arr[i]=='1'){
                    count++;
                    flag = true;
                }
                else if(flag&&arr[i]=='0'){
                    count++;
                    flag = false;
                }
            }
            System.out.println("#" + test_case + " "+ count);
        }
    }
}