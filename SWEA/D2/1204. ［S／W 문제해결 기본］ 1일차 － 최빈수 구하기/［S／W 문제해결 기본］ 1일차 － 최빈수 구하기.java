import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int test = sc.nextInt();
            int[] student = new int[1000];

            for(int i = 0; i<1000; i++){
                int num = sc.nextInt();
                student[num]++;
            }
            int max = student[0];
            int answer = 0;
            for(int i = 1; i<1000; i++){
                if(max<=student[i]){
                    max =student[i];
                    answer = i;
                }
            }
            System.out.println("#" + test_case+" " + answer);
		}
	}
}