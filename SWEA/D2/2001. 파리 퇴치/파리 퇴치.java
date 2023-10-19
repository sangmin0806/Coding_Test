
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
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];
            for(int i = 0; i<N; i++){
                for(int j  =0; j<N; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            int max = Integer.MIN_VALUE;
             for(int i = 0; i<N-M+1; i++){
                for(int j  =0; j<N-M+1; j++){
                    int sum =0;
                    for(int k = 0; k<M; k++){
                        for(int l = 0; l<M; l++){
                            sum +=map[i+k][j+l];
                        }
                    }
                    max = Math.max(max,sum);
                }
            }
            System.out.println("#"+test_case+" "+max);

		}
	}
}