import java.util.Scanner;
import java.io.FileInputStream;

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
            int[][]map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int rowsum = 0;
            int colsum = 0;
            int across = 0;
            int bcross = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 100; i++) {
                rowsum = 0;
                colsum = 0;
                for (int j = 0; j < 100; j++) {
                    rowsum += map[i][j];
                    colsum += map[j][i];
                }
                max = Math.max(max,rowsum);
                max = Math.max(max,colsum);
            }
            for (int i = 0; i < 100; i++) {
                across += map[i][i];
                bcross += map[i][99-i];
            }
            max = Math.max(max,across);
            max = Math.max(max,bcross);
            System.out.println("#"+test+" "+ max);
        }
    }
}