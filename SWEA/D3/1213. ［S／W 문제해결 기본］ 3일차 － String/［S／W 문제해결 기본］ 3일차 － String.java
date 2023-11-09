
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int test = sc.nextInt();
            String target = sc.next();
            String str = sc.next();
            int tlen = target.length();
            int len = str.length();
            int count = 0;
            for (int i = 0; i <len-tlen+1; i++) {
                String s = str.substring(i,i+tlen);
                if(target.equals(s)) count++;
            }
            System.out.println("#"+test_case+ " "+ count);
        }
    }
}